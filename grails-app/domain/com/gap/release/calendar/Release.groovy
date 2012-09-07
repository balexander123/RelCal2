package com.gap.release.calendar

import java.util.Date;

import org.bson.types.ObjectId

class Release {

	ObjectId id
	String releaseName
	String releaseDesc
	Date startDate
	Integer relDurationDays
	Integer numIterations
	Integer iterationNumber
	String releaseFormat
	
    static constraints = {
    }
}
