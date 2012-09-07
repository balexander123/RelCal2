package com.gap.release.calendar

import org.springframework.beans.BeansException
import org.springframework.context.ApplicationContext
import org.springframework.context.ApplicationContextAware
import org.grails.datastore.mapping.mongo.MongoDatastore

import com.mongodb.Mongo

class DatastoreService implements ApplicationContextAware {

	def applicationContext
	
    MongoDatastore releaseCalendarDatastore() {
		MongoDatastore datastore = applicationContext.mongoDatastore
		return datastore
	}
	
	@Override
	public void setApplicationContext(ApplicationContext ctx)
	throws BeansException {
		applicationContext = ctx
	}
}