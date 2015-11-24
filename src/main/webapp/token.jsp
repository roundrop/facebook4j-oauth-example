<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>

<html>
<head>
<meta content="text/html; charset=utf-8" http-equiv="Content-Type" />
<title>Sign in with Facebook example</title>
</head>
<body>
<h1>Your access token info:</h1>
<ul>
  <li>access_token: ${token.token}</li>
  <li>token_type: ${token.type}</li>
  <li>expires_in: ${token.expires}</li>
</ul>
</form>
</body>
</html>