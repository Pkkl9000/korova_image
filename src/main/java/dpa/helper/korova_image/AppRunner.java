package dpa.helper.korova_image;

import dpa.helper.korova_image.callback.EventHandler;
import dpa.helper.korova_image.event_reactor.Event;
//import dpa.helper.korova_image.event_reactor.EventGenerator;
import dpa.helper.korova_image.event_reactor.EventReactiveHandler;
import dpa.helper.korova_image.mouse_key_hook.EventGenerator;
import dpa.helper.korova_image.mouse_key_hook.EventListener;
import dpa.helper.korova_image.mouse_key_hook.MouseAndKeyboardHooking;
import dpa.helper.korova_image.mouse_key_hook.MouseEventHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;


@RequiredArgsConstructor
@Component
public class AppRunner implements ApplicationRunner {

    private final MouseEventHandler handler = new MouseEventHandler();

    @Override
    public void run(ApplicationArguments args) {

        MouseAndKeyboardHooking.MouseListener();

        EventGenerator eventGenerator = new EventGenerator();

        // Создаем экземпляр EventListener и передаем ему генератор событий
        EventListener eventListener = new EventListener(eventGenerator);

//        EventGenerator generator = new EventGenerator();
//        EventReactiveHandler handler = new EventReactiveHandler();

        // Подписка на события и вызов метода start() при получении события
//        Flux<Event> eventFlux = generator.generateEvents();
//        eventFlux.subscribe(handler::start); // Вызов метода start() при получении события
//
//        // Дайте генератору работать некоторое время
//        try {
//            Thread.sleep(10000); // 10 секунд
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

//        EventHandler handler = new EventHandler();
//        EventTrigger trigger = new EventTrigger(handler);
//
//        trigger.triggerEvent(); // Вызов триггера

//        new MethodCaller().callMethod("sign");
//
//        MouseAndKeyboardHooking.MouseListener();

    }

//    public void MouseListenerExample() {
//        eventGenerator.getEventFlux().subscribe(handler::handleEvent);
//    }
}

