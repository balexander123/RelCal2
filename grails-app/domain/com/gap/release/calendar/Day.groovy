package com.gap.release.calendar

import java.util.Date;

import org.bson.types.ObjectId

class Day {
	Date relCalDay
	String release
	Integer iterationNumber
	Integer iterationDay
	ObjectId releaseId

    static constraints = {
    }
}
