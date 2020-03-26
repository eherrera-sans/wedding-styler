package com.sanservices.websitesapi.modules.wedding.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sanservices.websitesapi.modules.wedding.entity.InspirationMedia;
import lombok.SneakyThrows;
import lombok.val;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import static org.jooq.lambda.Seq.seq;

@Repository
public class InspirationMediaRepositoryImpl implements InspirationMediaRepository {

    private final List<InspirationMedia> inspirationMedia;

    @SneakyThrows(IOException.class)
    public InspirationMediaRepositoryImpl(
            @Value("classpath:json/look-book-images.json") Resource resource,
            ObjectMapper mapper) {

        try (val is = resource.getInputStream()) {
            val type = new TypeReference<List<InspirationMedia>>() {
            };

            inspirationMedia = mapper.readValue(is, type);
        }
    }

    @Override
    public Optional<InspirationMedia> findByInspirationId(int inspirationId) {
        return seq(inspirationMedia).findFirst(media -> media.getInspirationId() == inspirationId);
    }
}
