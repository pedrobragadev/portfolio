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
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.io.File;

@Configuration
@ConditionalOnClass({FFmpegFrameGrabber.class, AnimatedGifEncoder.class})
public class GiftyAutoConfiguration {

    @Value("${multipart.location}/gif/")
    private String gifLocation;

    @Bean
    @ConditionalOnProperty(prefix = "com.pbd.gifty", name = "create-result-dir")
    public Boolean createResultDir(){
        File gifFolder = new File(gifLocation);
        if (!gifFolder.exists()){
            gifFolder.mkdir();
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

    }
}
