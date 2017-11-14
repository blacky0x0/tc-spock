package com.example

import com.groovycoder.spockdockerextension.Testcontainers
import groovy.util.logging.Slf4j
import org.openqa.selenium.remote.DesiredCapabilities
import org.openqa.selenium.remote.RemoteWebDriver
import org.testcontainers.containers.BrowserWebDriverContainer
import spock.lang.Shared
import spock.lang.Specification

import static org.testcontainers.containers.BrowserWebDriverContainer.VncRecordingMode.RECORD_ALL

@Slf4j
@Testcontainers
class Example extends Specification {

    @Shared
    BrowserWebDriverContainer container = new BrowserWebDriverContainer()
            .withDesiredCapabilities(DesiredCapabilities.chrome())
            .withRecordingMode(RECORD_ALL, new File("./"))

    RemoteWebDriver driver

    def setup() {
        driver = container.getWebDriver()
        println 'VNC address: ' + container.getVncAddress()
        println 'Selenium address: ' + container.getSeleniumAddress()
        println 'Password: ' + container.getPassword()
        println 'Port: ' + container.getPort()
    }

    def "Get example.com page"() {

        given: 'FQDN'
        String domain = 'http://example.com/'

        when: 'Open browser & get start page'
        driver.get(domain)

        then: 'Just to set a brake point'
        int a = 10
    }


}