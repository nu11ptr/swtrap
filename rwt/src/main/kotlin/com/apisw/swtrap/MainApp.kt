package com.apisw.swtrap

import org.eclipse.rap.rwt.application.Application
import org.eclipse.rap.rwt.application.ApplicationConfiguration
import org.eclipse.rap.rwt.application.ApplicationRunner
import org.eclipse.rap.rwt.engine.RWTServlet
import org.eclipse.rap.rwt.engine.RWTServletContextListener
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.boot.web.servlet.ServletRegistrationBean
import org.springframework.context.annotation.Bean
import javax.servlet.ServletContextEvent

class MainConfig : ApplicationConfiguration {
    override fun configure(app: Application) {
        app.addEntryPoint("/rwt", MainEntry::class.java, null)
    }
}

class RWTContextListener : RWTServletContextListener() {
    private var runner: ApplicationRunner? = null

    override fun contextInitialized(event: ServletContextEvent) {
        runner = ApplicationRunner(MainConfig(), event.servletContext).also {
            it.start()
        }
    }

    override fun contextDestroyed(event: ServletContextEvent) {
        runner?.stop()
        runner = null
    }
}

@SpringBootApplication
class MainApp {
    @Bean
    fun servletRegistrationBean(): ServletRegistrationBean<RWTServlet> {
        return ServletRegistrationBean(RWTServlet(), "/rwt")
    }

    @Bean
    fun rwtContextListener(): RWTContextListener = RWTContextListener()
}

fun main(args: Array<String>) {
    runApplication<MainApp>(*args)
}
