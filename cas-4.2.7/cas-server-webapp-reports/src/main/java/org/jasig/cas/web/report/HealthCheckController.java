package org.jasig.cas.web.report;

import org.jasig.cas.monitor.HealthCheckMonitor;
import org.jasig.cas.monitor.HealthStatus;
import org.jasig.cas.monitor.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.async.WebAsyncTask;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.NotNull;
import java.util.Map;
import java.util.concurrent.Callable;


/**
 * Reports overall CAS health based on the observations of the configured {@link HealthCheckMonitor} instance.
 *
 * @author Marvin S. Addison
 * @since 3.5
 */
@Controller("healthCheckController")
@RequestMapping("/status")
public class HealthCheckController {

    @NotNull
    @Autowired
    @Qualifier("healthCheckMonitor")
    private HealthCheckMonitor healthCheckMonitor;

    @Value("${cas.status.timeout:10000}")
    private long timeout;
    
    /**
     * Handle request.
     *
     * @param request the request
     * @param response the response
     * @return the model and view
     * @throws Exception the exception
     */
    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    protected WebAsyncTask<HealthStatus> handleRequestInternal(
            final HttpServletRequest request, final HttpServletResponse response)
            throws Exception {

        final Callable<HealthStatus> asyncTask = new Callable<HealthStatus>() {
            @Override
            public HealthStatus call() throws Exception {
                final HealthStatus healthStatus = healthCheckMonitor.observe();
                final StringBuilder sb = new StringBuilder();
                sb.append("Health: ").append(healthStatus.getCode());
                String name;
                Status status;
                int i = 0;
                for (final Map.Entry<String, Status> entry : healthStatus.getDetails().entrySet()) {
                    name = entry.getKey();
                    status = entry.getValue();
                    response.addHeader("X-CAS-" + name, String.format("%s;%s", status.getCode(), status.getDescription()));

                    sb.append("\n\n\t").append(++i).append('.').append(name).append(": ");
                    sb.append(status.getCode());
                    if (status.getDescription() != null) {
                        sb.append(" - ").append(status.getDescription());
                    }
                }
                response.setStatus(healthStatus.getCode().value());
                response.setContentType("text/plain");
                response.getOutputStream().write(sb.toString().getBytes(response.getCharacterEncoding()));
                return null;
            }
        };
        
        return new WebAsyncTask<>(this.timeout, asyncTask);
    }
}
[ZoneTransfer]
ZoneId=3
