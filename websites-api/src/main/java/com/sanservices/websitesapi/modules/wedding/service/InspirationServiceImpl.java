package com.sanservices.websitesapi.modules.wedding.service;

import com.sanservices.websitesapi.modules.wedding.model.InspirationResponseModel;
import com.sanservices.websitesapi.modules.wedding.repository.InspirationMediaRepository;
import com.sanservices.websitesapi.modules.wedding.repository.InspirationRepository;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.jooq.lambda.Seq.seq;

@Service
@RequiredArgsConstructor
@CacheConfig(cacheNames = "inspirations")
public class InspirationServiceImpl implements InspirationService {

    private final InspirationRepository inspirationRepository;
    private final InspirationMediaRepository inspirationMediaRepository;

    @Cacheable(unless = "#result.empty")
    @Override
    public List<InspirationResponseModel> getInspirations() {
        val inspirations = inspirationRepository.findAll();
        return seq(inspirations).map(inspiration -> {
            val media = inspirationMediaRepository.findByInspirationId(inspiration.getId());
            val model = new InspirationResponseModel();
            model.setInspiration(inspiration);
            model.setMedia(media.orElse(null));
            return model;
        }).toList();
    }
}
