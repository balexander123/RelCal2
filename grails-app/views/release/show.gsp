
<%@ page import="com.gap.release.calendar.Release" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'release.label', default: 'Release')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-release" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-release" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list release">
			
				<g:if test="${releaseInstance?.iterationNumber}">
				<li class="fieldcontain">
					<span id="iterationNumber-label" class="property-label"><g:message code="release.iterationNumber.label" default="Iteration Number" /></span>
					
						<span class="property-value" aria-labelledby="iterationNumber-label"><g:fieldValue bean="${releaseInstance}" field="iterationNumber"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${releaseInstance?.numIterations}">
				<li class="fieldcontain">
					<span id="numIterations-label" class="property-label"><g:message code="release.numIterations.label" default="Num Iterations" /></span>
					
						<span class="property-value" aria-labelledby="numIterations-label"><g:fieldValue bean="${releaseInstance}" field="numIterations"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${releaseInstance?.relDurationDays}">
				<li class="fieldcontain">
					<span id="relDurationDays-label" class="property-label"><g:message code="release.relDurationDays.label" default="Rel Duration Days" /></span>
					
						<span class="property-value" aria-labelledby="relDurationDays-label"><g:fieldValue bean="${releaseInstance}" field="relDurationDays"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${releaseInstance?.releaseDesc}">
				<li class="fieldcontain">
					<span id="releaseDesc-label" class="property-label"><g:message code="release.releaseDesc.label" default="Release Desc" /></span>
					
						<span class="property-value" aria-labelledby="releaseDesc-label"><g:fieldValue bean="${releaseInstance}" field="releaseDesc"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${releaseInstance?.releaseFormat}">
				<li class="fieldcontain">
					<span id="releaseFormat-label" class="property-label"><g:message code="release.releaseFormat.label" default="Release Format" /></span>
					
						<span class="property-value" aria-labelledby="releaseFormat-label"><g:fieldValue bean="${releaseInstance}" field="releaseFormat"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${releaseInstance?.releaseName}">
				<li class="fieldcontain">
					<span id="releaseName-label" class="property-label"><g:message code="release.releaseName.label" default="Release Name" /></span>
					
						<span class="property-value" aria-labelledby="releaseName-label"><g:fieldValue bean="${releaseInstance}" field="releaseName"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${releaseInstance?.startDate}">
				<li class="fieldcontain">
					<span id="startDate-label" class="property-label"><g:message code="release.startDate.label" default="Start Date" /></span>
					
						<span class="property-value" aria-labelledby="startDate-label"><g:formatDate date="${releaseInstance?.startDate}" /></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${releaseInstance?.id}" />
					<g:link class="edit" action="edit" id="${releaseInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
