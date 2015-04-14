package com.tianyi.bph.common;

import java.text.SimpleDateFormat;

import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.DeserializationFeature;

public class CustomJacksonObjectMapper extends ObjectMapper {
	private static final long serialVersionUID = 1L;

	public CustomJacksonObjectMapper() {
	    super();
//	    this.configure(DeserializationFeature.UNWRAP_ROOT_VALUE, true);
//	    this.configure(SerializationFeature.WRAP_ROOT_VALUE, true);
//	    this.setSerializationInclusion(Include.NON_NULL);
	    
	    this.setVisibility(PropertyAccessor.FIELD, Visibility.ANY);
	    this.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
	    this.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
	    this.setSerializationInclusion(Include.NON_NULL);
	}
}
