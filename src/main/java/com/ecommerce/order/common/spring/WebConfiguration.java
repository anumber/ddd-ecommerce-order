package com.ecommerce.order.common.spring;

import com.ecommerce.order.common.domain.BaseEnum;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.converter.ConverterFactory;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * <p>
 * </p>
 */
@Configuration
public class WebConfiguration implements WebMvcConfigurer {

    private CorsConfiguration buildConfig() {
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        // 1允许任何域名使用
        corsConfiguration.addAllowedOrigin("*");
        // 2允许任何头
        corsConfiguration.addAllowedHeader("*");
        // 3允许任何方法（post、get等）
        corsConfiguration.addAllowedMethod("*");
        return corsConfiguration;
    }

    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", buildConfig());
        return new CorsFilter(source);
    }

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverterFactory(new StringCodeToEnumConverterFactory());
    }

    public static class StringCodeToEnumConverterFactory implements ConverterFactory<String, BaseEnum> {
        /**
         * 获取一个从 String 转化为 T 的转换器，T 是一个泛型，有多个实现
         *
         * @param targetType 转换后的类型
         * @return 返回一个转化器
         */
        @Override
        public <T extends BaseEnum> Converter<String, T> getConverter(Class<T> targetType) {
            return new StringToEnumConverter<>(targetType);
        }

        public static class StringToEnumConverter<T extends BaseEnum> implements Converter<String, T> {
            private final Class<T> targetType;

            public StringToEnumConverter(Class<T> targetType) {
                this.targetType = targetType;
            }

            @Override
            public T convert(String source) {
                return BaseEnum.fromValue(targetType, Integer.parseInt(source));
            }
        }
    }
}