package ru.home.spring_context.entities;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("ru.home.spring_context")
public class AppConfig {

//    @Bean(name = "cameraRoll")
    public CameraRoll cameraRoll() {
        return new ColorCameraRoll();
    }

//    @Bean(name = "camera")
    public Camera camera(CameraRoll cameraRoll) {
        Camera camera = new CameraImpl();
        camera.setCameraRoll(cameraRoll);
        return camera;
    }
}
