package com.example.kb;

import io.micrometer.core.instrument.Clock;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.statsd.StatsdConfig;
import io.micrometer.statsd.StatsdFlavor;
import io.micrometer.statsd.StatsdMeterRegistry;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class KbApplication {

	public static void main(String[] args) {
		SpringApplication.run(KbApplication.class, args);

		StatsdConfig config = new StatsdConfig() {
			@Override
			public String get(String k) {
				return null;
			}
		};

		MeterRegistry registry = new StatsdMeterRegistry(config, Clock.SYSTEM);
	}

}
