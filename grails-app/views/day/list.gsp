
<%@ page import="com.gap.release.calendar.Day" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'day.label', default: 'Day')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-day" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-day" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="iterationDay" title="${message(code: 'day.iterationDay.label', default: 'Iteration Day')}" />
					
						<g:sortableColumn property="iterationNumber" title="${message(code: 'day.iterationNumber.label', default: 'Iteration Number')}" />
					
						<g:sortableColumn property="relCalDay" title="${message(code: 'day.relCalDay.label', default: 'Rel Cal Day')}" />
					
						<g:sortableColumn property="release" title="${message(code: 'day.release.label', default: 'Release')}" />
					
						<g:sortableColumn property="releaseId" title="${message(code: 'day.releaseId.label', default: 'Release Id')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${dayInstanceList}" status="i" var="dayInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${dayInstance.id}">${fieldValue(bean: dayInstance, field: "iterationDay")}</g:link></td>
					
						<td>${fieldValue(bean: dayInstance, field: "iterationNumber")}</td>
					
						<td><g:formatDate date="${dayInstance.relCalDay}" /></td>
					
						<td>${fieldValue(bean: dayInstance, field: "release")}</td>
					
						<td>${fieldValue(bean: dayInstance, field: "releaseId")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${dayInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
