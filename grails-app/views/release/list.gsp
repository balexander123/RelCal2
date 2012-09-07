
<%@ page import="com.gap.release.calendar.Release" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'release.label', default: 'Release')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-release" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-release" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="iterationNumber" title="${message(code: 'release.iterationNumber.label', default: 'Iteration Number')}" />
					
						<g:sortableColumn property="numIterations" title="${message(code: 'release.numIterations.label', default: 'Num Iterations')}" />
					
						<g:sortableColumn property="relDurationDays" title="${message(code: 'release.relDurationDays.label', default: 'Rel Duration Days')}" />
					
						<g:sortableColumn property="releaseDesc" title="${message(code: 'release.releaseDesc.label', default: 'Release Desc')}" />
					
						<g:sortableColumn property="releaseFormat" title="${message(code: 'release.releaseFormat.label', default: 'Release Format')}" />
					
						<g:sortableColumn property="releaseName" title="${message(code: 'release.releaseName.label', default: 'Release Name')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${releaseInstanceList}" status="i" var="releaseInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${releaseInstance.id}">${fieldValue(bean: releaseInstance, field: "iterationNumber")}</g:link></td>
					
						<td>${fieldValue(bean: releaseInstance, field: "numIterations")}</td>
					
						<td>${fieldValue(bean: releaseInstance, field: "relDurationDays")}</td>
					
						<td>${fieldValue(bean: releaseInstance, field: "releaseDesc")}</td>
					
						<td>${fieldValue(bean: releaseInstance, field: "releaseFormat")}</td>
					
						<td>${fieldValue(bean: releaseInstance, field: "releaseName")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${releaseInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
