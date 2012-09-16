package com.gap.release.calendar

import grails.converters.JSON
import org.bson.types.ObjectId
import org.joda.time.*
import org.joda.time.format.*
import java.text.SimpleDateFormat
import org.grails.datastore.mapping.mongo.MongoDatastore

class RelCalRestController {
	
	def calDayGeneratorService
	def datastoreService

    def index() { }
	
	def list = {
		def List <Release> releaseList = Release.findAll()
		render releaseList as JSON
	}
	
	def listRel = {
		def release = Release.findByReleaseName(params.releaseID)
		render release.encodeAsJSON()
	}
	
	def listDay = {
		def release = Release.findByReleaseName(params.releaseID)
		
		Date calendarDate = new SimpleDateFormat("yyyy-MM-dd").parse(params.calDate)

		def day = Day.findByRelCalDayAndReleaseId(calendarDate,release.id)
		render day.encodeAsJSON()
	}
	
	def save = {
		def json = request.JSON
		
		def release = new Release()
		
		release.releaseName = json.releaseName
		release.releaseDesc = json.releaseDesc
		DateTimeFormatter parser = ISODateTimeFormat.dateTimeParser()
		DateTime startDate = parser.parseDateTime(json.startDate)
		release.startDate = new SimpleDateFormat("yyyy-MM-dd").parse(json.startDate)
		release.relDurationDays = json.duration.toInteger()
		release.numIterations = json.iterations.toInteger()
		release.iterationNumber = json.iterationNumber.toInteger()
		release.releaseFormat = json.releaseFormat
		
		if (release.save()) {
			calDayGeneratorService.generateDays(release)
			render contentType: "application/json", {
				// Return the ID of the new release
				['id' : release.id.toString()]
			}
		}
		else {
			render contentType: "application/json", {
				['status' : 'FAILED']
			}
		}
	}
}
