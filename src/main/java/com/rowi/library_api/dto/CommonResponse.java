package com.rowi.library_api.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.rowi.library_api.model.Book;
import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CommonResponse<T> {
    private String code;
    private String message;
    private T data;

    public static <T> CommonResponse<T> accepted(T data, String code) {
        CommonResponse<T> response = CommonResponse.<T>builder()
                .code(code)
                .message(HttpStatus.ACCEPTED.name())
                .data(data)
                .build();
        return response;
    }

    public static <T> CommonResponse<T> ok(T data) {
        CommonResponse<T> response = CommonResponse.<T>builder()
                .data(data)
                .build();
        return response;
    }

    public static <T> CommonResponse<T> okList(T dataList, String code) {
        CommonResponse<T> response = CommonResponse.<T>builder()
                .code(code)
                .message(HttpStatus.OK.name())
                .data(dataList)
                .build();
        return response;
    }

}
