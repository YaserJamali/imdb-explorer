package com.globox.ali.converter;

import com.globox.ali.dto.BaseDto;
import com.globox.ali.entities.BaseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public interface BaseConverter<E extends BaseEntity, D extends BaseDto> {

    E convertDto(D d);

    D convertEntity(E e);

    default List<E> convertDto(List<D> dList) {

        if (dList != null) {
            return dList.stream()
                    .map(i -> {
                                try {
                                    return convertDto(i);
                                } catch (Exception ex) {
                                    return null;
                                }
                            }
                    ).collect(Collectors.toList());
        }
        return null;
    }

    default List<D> convertEntity(List<E> eList) {

        if (eList != null) {
            return eList.stream()
                    .map(this::convertEntity).collect(Collectors.toList());
        }
        return null;

    }
}