package com.adobe.aem.guides.wknd.core.models;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.models.annotations.Default;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.InjectionStrategy;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

import static org.apache.sling.api.resource.ResourceResolver.PROPERTY_RESOURCE_TYPE;

@Model(adaptables = Resource.class)
public class SalientFeaturesModel {

    @ValueMapValue(name=PROPERTY_RESOURCE_TYPE, injectionStrategy= InjectionStrategy.OPTIONAL)
    @Default(values="No resourceType")
    protected String resourceType;
    @SlingObject
    private Resource currentResource;
    @SlingObject
    private ResourceResolver resourceResolver;
    private String header;
//    private List<DetailModel> detailModels = new ArrayList<>();

    @PostConstruct
    protected void init() {
        header = "Tính năng nổi bật";

//        DetailModel description = new DetailModel();
//        description.setTitle("Mở tài khoản số đẹp nhanh chóng");
//        description.setDescription("Mở tài khoản nhanh chóng chỉ vài phút hoàn toàn online, chọn số tài khoản đẹp như ý, hoàn toàn eKYC");
//        detailModels.add(description);
    }

    public String getHeader() {
        return header;
    }
//    public List<DetailModel> getDetailModels() {
//        return detailModels;
//    }
}
