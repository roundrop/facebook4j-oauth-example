<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>

<html>
<head>
<meta content="text/html; charset=utf-8" http-equiv="Content-Type" />
<title>Sign in with Facebook example</title>
</head>
<body>
<p>Generated your device code: <strong>${deviceCode.getUserCode()}</strong></p>
<hr />
<p>Go to here and enter the generated device code: <a href="${deviceCode.getVerificationUri()}" target="_blank">${deviceCode.getVerificationUri()}</a></p>
<p>After that, click <a href="deviceSignin">here</a> to login.</p>
</body>
</html>