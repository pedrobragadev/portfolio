package com.pbd.gifty;

import com.madgag.gif.fmsware.AnimatedGifEncoder;
import com.pbd.gifty.service.ConverterService;
import com.pbd.gifty.service.GifEncoderService;
import com.pbd.gifty.service.VideoDecoderService;
import org.bytedeco.javacv.FFmpegFrameGrabber;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.inject.Inject;
import java.io.File;

@Configuration
@ConditionalOnClass({FFmpegFrameGrabber.class, AnimatedGifEncoder.class})
@EnableConfigurationProperties(GiftyProperties.class)
public class GiftyAutoConfiguration {

    @Inject
    private GiftyProperties properties;

    @Bean
    @ConditionalOnProperty(prefix = "com.pbd.gifty", name = "create-result-dir")
    public Boolean createResultDir(){
        if (!properties.getGifLocation().exists()){
            properties.getGifLocation().mkdir();
        }
        return true;
    }

    @Bean
    @ConditionalOnMissingBean(VideoDecoderService.class)
    public VideoDecoderService videoDecoderService(){
        return new VideoDecoderService();
    }

    @Bean
    @ConditionalOnMissingBean(GifEncoderService.class)
    public GifEncoderService gifEncoderService() {
        return new GifEncoderService();
    }

    @Bean
    @ConditionalOnMissingBean(ConverterService.class)
    public ConverterService converterService() {
        return new ConverterService();
    }

    @Configuration
    @ConditionalOnWebApplication
    public static class WebConfiguration {

        @Value("${multipart.location}/gif/")
        private String gifLocation;

        @Bean
        public WebMvcConfigurer webMvcConfigurer() {
            return new WebMvcConfigurer () {
                @Override
                public void addResourceHandlers(ResourceHandlerRegistry registry) {
                    registry.addResourceHandler("/gif/**")
                            .addResourceLocations("file:" + gifLocation);
                    WebMvcConfigurer.super.addResourceHandlers(registry);
                }
            };
        }
    }
}
