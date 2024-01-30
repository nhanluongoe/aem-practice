package com.adobe.aem.guides.wknd.core.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import jdk.nashorn.internal.objects.annotations.Getter;
import lombok.Data;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.models.annotations.Default;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;
import org.apache.sling.models.annotations.injectorspecific.InjectionStrategy;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import java.util.ArrayList;
import java.util.List;

import static org.apache.sling.api.resource.ResourceResolver.PROPERTY_RESOURCE_TYPE;

@Model(adaptables = { Resource.class }, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
@Data
public class SalientFeaturesModel {

  @ValueMapValue(name = PROPERTY_RESOURCE_TYPE)
  @Default(values = "No resourceType")
  protected String resourceType;
  @SlingObject
  private Resource currentResource;
  @SlingObject
  private ResourceResolver resourceResolver;

  @ValueMapValue
  private String header;

  @ChildResource
  private List<ListStep> listSteps;

  @PostConstruct
  protected void init() {

  }

      @Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
      public static class ListStep {
        @Inject
        private Boolean isExpand;
        @Inject
        private String title;
        @Inject
        private String description;
      }
}
