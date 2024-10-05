package com.ProjectLive.Liveasy.Service;

import com.ProjectLive.Liveasy.Entity.Load;
import com.ProjectLive.Liveasy.Repos.LoadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class LoadService {

    @Autowired
    private LoadRepository loadRepository;

    public Load saveLoad(Load load) {
        return loadRepository.save(load);
    }
    public List<Load> getLoadsByShipperId(UUID shipperId) {
        return loadRepository.findByShipperId(shipperId);
    }

    public Load getLoadById(UUID loadId) {
        return loadRepository.findById(loadId).orElse(null);
    }

    public Load updateLoad(UUID loadId, Load loadDetails) {
        Load existingLoad = loadRepository.findById(loadId).orElse(null);
        if (existingLoad != null) {
            existingLoad.setLoadingPoint(loadDetails.getLoadingPoint());
            existingLoad.setUnloadingPoint(loadDetails.getUnloadingPoint());
            existingLoad.setProductType(loadDetails.getProductType());
            existingLoad.setTruckType(loadDetails.getTruckType());
            existingLoad.setNoOfTrucks(loadDetails.getNoOfTrucks());
            existingLoad.setWeight(loadDetails.getWeight());
            existingLoad.setComment(loadDetails.getComment());
            existingLoad.setDate(loadDetails.getDate());
            return loadRepository.save(existingLoad);
        }
        return null;
    }


    public boolean deleteLoad(UUID loadId) {
        loadRepository.deleteById(loadId);
        return false;
    }
}
