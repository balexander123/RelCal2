package com.gap.release.calendar

import org.joda.time.DateTime
import org.joda.time.Period

class CalDayGeneratorService {
	
    def generateDays(Release release) {		
		Integer totalDuration = 0
		DateTime nextReleaseDate = new DateTime(release.getStartDate())
		nextReleaseDate = nextReleaseDate.plus(Period.days(release.getRelDurationDays()*release.getNumIterations()))
		Date relCalDate = release.getStartDate()
		Integer iterationNumber = release.getIterationNumber()
		Integer relSuffix = 1
		while (totalDuration < 365) {
			Integer relCnt = 0
		    while (relCnt < release.getRelDurationDays()) {
				String relYearName = nextReleaseDate.toString()
				relYearName = relYearName[2..3]
				def relMonth = nextReleaseDate.monthOfYear.toString().padLeft(2,'0')
				String relPrefixName = relYearName + '.' + relMonth
		
				for (int iterationCnt=0; iterationCnt < release.getNumIterations(); iterationCnt++) {
					int itDay=1
					for (int iterationDays=0; iterationDays < (release.getRelDurationDays())/release.getNumIterations(); iterationDays++ ) {
						def day = new Day()
						day.iterationNumber = iterationNumber
						day.relCalDay = relCalDate
						day.release = relPrefixName + '.' + relSuffix.toString()
						day.releaseId = release.id
						if ((relCalDate[Calendar.DAY_OF_WEEK] != Calendar.SATURDAY) &&
							(relCalDate[Calendar.DAY_OF_WEEK] != Calendar.SUNDAY)) {
							day.iterationDay = itDay++
						} else {
							day.iterationDay = itDay
						}
						day.save()
						relCalDate = relCalDate + 1
						relCnt++
					}
					iterationNumber++
					if (relSuffix == 1)
						relSuffix = 2
					else
						relSuffix = 1
				}
		    }
		    totalDuration = totalDuration + release.getRelDurationDays()
			nextReleaseDate = nextReleaseDate.plus(Period.days(release.getRelDurationDays()))
		}
    }
}
