<%@ page import="com.gap.release.calendar.Day" %>



<div class="fieldcontain ${hasErrors(bean: dayInstance, field: 'iterationDay', 'error')} ">
	<label for="iterationDay">
		<g:message code="day.iterationDay.label" default="Iteration Day" />
		
	</label>
	<g:field type="number" name="iterationDay" value="${fieldValue(bean: dayInstance, field: 'iterationDay')}" />
</div>

<div class="fieldcontain ${hasErrors(bean: dayInstance, field: 'iterationNumber', 'error')} ">
	<label for="iterationNumber">
		<g:message code="day.iterationNumber.label" default="Iteration Number" />
		
	</label>
	<g:field type="number" name="iterationNumber" value="${fieldValue(bean: dayInstance, field: 'iterationNumber')}" />
</div>

<div class="fieldcontain ${hasErrors(bean: dayInstance, field: 'relCalDay', 'error')} ">
	<label for="relCalDay">
		<g:message code="day.relCalDay.label" default="Rel Cal Day" />
		
	</label>
	<g:datePicker name="relCalDay" precision="day" value="${dayInstance?.relCalDay}" />
</div>

<div class="fieldcontain ${hasErrors(bean: dayInstance, field: 'release', 'error')} ">
	<label for="release">
		<g:message code="day.release.label" default="Release" />
		
	</label>
	<g:textField name="release" value="${dayInstance?.release}" />
</div>

<div class="fieldcontain ${hasErrors(bean: dayInstance, field: 'releaseId', 'error')} ">
	<label for="releaseId">
		<g:message code="day.releaseId.label" default="Release Id" />
		
	</label>
	
</div>

