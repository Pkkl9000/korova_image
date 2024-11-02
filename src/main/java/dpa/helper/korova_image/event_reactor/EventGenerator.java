package dpa.helper.korova_image.event_reactor;

import reactor.core.publisher.Flux;
import java.time.Duration;

public class EventGenerator {

    public Flux<Event> generateEvents() {
        return Flux.interval(Duration.ofSeconds(1))
                .map(i -> new Event("Event number: " + i));
    }
}
