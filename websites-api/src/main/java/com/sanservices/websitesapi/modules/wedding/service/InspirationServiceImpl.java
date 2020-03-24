package com.sanservices.websitesapi.modules.wedding.service;

import com.sanservices.websitesapi.modules.wedding.entity.Inspiration;
import com.sanservices.websitesapi.modules.wedding.repository.InspirationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InspirationServiceImpl implements InspirationService {

    private final InspirationRepository inspirationRepository;

    @Override
    public List<Inspiration> getAllInspirations() {
        return inspirationRepository.findAll();
    }
}
