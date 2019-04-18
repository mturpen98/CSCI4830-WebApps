import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import javax.servlet.annotation.WebServlet;
@WebServlet(name = "Input", urlPatterns = {
    "/Input"
})
public class Input extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest request,
        HttpServletResponse response)
    throws
    ServletException, IOException {
        response.setContentType("text/html");
        final PrintWriter out = response.getWriter();

        // If the checkbox isn't checked the value is null
        // If the checkbox isn't checked the value is "on"
        String userName = request.getParameter("name");
		
		out.print("<head>\n" +
						"<meta charset='utf-8'>\n" +
						"<title>Welcome to Budgt</title>\n" +
						"<style>\n" +
						"@import url(https://fonts.googleapis.com/css?family=Roboto:300);\n" +
						"	.login-page\n" +
						"	{ width: 360px;\n" +
						"		padding: 8% 0 0;\n" +
						"		margin: auto; }\n" +
						"	.form { position: relative;\n" +
						"		z-index: 1;\n" +
						"		background: #FFFFFF;\n" +
						"		max-width: 800px;\n" +
						"		margin: 0 auto 100px;\n" +
						"		padding: 45px;\n" +
						"		text-align: center;\n" +
						"		box-shadow: 0 0 20px 0 rgba(0, 0, 0, 0.2), 0 5px 5px 0 rgba(0, 0, 0, 0.24); }\n" +
						"	.form input,textarea,select { font-family: 'Roboto', sans-serif;\n" +
						"		outline: 0;\n" +
						"		background: #f2f2f2;\n" +
						"		width: 100%;\n" +
						"		border: 0;\n" +
						"		margin: 0 0 15px;\n" +
						"		padding: 15px;\n" +
						"		box-sizing: border-box;\n" +
						"		font-size: 14px; }\n" +
						"	.form button { font-family: 'Roboto', sans-serif;\n" +
						"		text-transform: uppercase;\n" +
						"		outline: 0;\n" +
						"		background: #4CAF50;\n" +
						"		width: 50%;\n" +
						"		border: 0;\n" +
						"		color: #FFFFFF;\n" +
						"		padding: 15px;\n" +
						"		font-size: 14px;\n" +
						"		-webkit-transition: all 0.3 ease;\n" +
						"		transition: all 0.3 ease;\n" +
						"		cursor: pointer; }\n" +
						"	.form button:hover,.form button:active,.form button:focus { background: #43A047; }\n" +
						"	.container { position: relative;\n" +
						"		z-index: 1;\n" +
						"		max-width: 300px;\n" +
						"		margin: 0 auto; }\n" +
						"	.container:before, .container:after { content: '';\n" +
						"		display: block;\n" +
						"		clear: both; }\n" +
						"	.container .info { margin: 50px auto;\n" +
						"		text-align: center; }\n" +
						"	.container .info h1 { margin: 0 0 15px;\n" +
						"		padding: 0;\n" +
						"		font-size: 36px;\n" +
						"		font-weight: 300;\n" +
						"		color: #1a1a1a; }\n" +
						"	.container .info span { color: #4d4d4d;\n" +
						"		font-size: 12px; }\n" +
						"	.container .info span a { color: #000000;\n" +
						"		text-decoration: none; }\n" +
						"	.container .info span .fa { color: #EF3B3A; }\n" +
						"	body { background: #76b852; /* fallback for old browsers */\n" +
						"		background: -webkit-linear-gradient(right, #76b852, #8DC26F);\n" +
						"		background: -moz-linear-gradient(right, #76b852, #8DC26F);\n" +
						"		background: -o-linear-gradient(right, #76b852, #8DC26F);\n" +
						"		background: linear-gradient(to left, #76b852, #8DC26F);\n" +
						"		font-family: 'Roboto', sans-serif;\n" +
						"		-webkit-font-smoothing: antialiased;\n" +
						"		-moz-osx-font-smoothing: grayscale; }\n" +
						"	table, th, td { margin:10px;\n" +
						"		padding:10px 30px 10px 30px; }\n" +
						"	.tab { overflow:hidden;\n" +
						"		border: 1px solid #ccc;\n" +
						"		background-color: #43A047; }\n" +
						"	.tab button { background-color: inherit;\n" +
						"		float: left;\n" +
						"		border: none;\n" +
						"		outline: none;\n" +
						"		cursor: pointer;\n" +
						"		padding: 14px 16px;\n" +
						"		transition: 0.3s; }\n" +
						"	.tab button:hover { background-color: #ddd; }\n" +					
						"	.tab button.active { background-color: #ccc; }\n" +
						"	.tabcontent { display: none;\n" +
						"		padding: 6px 12px;\n" +
						"		border-top: none; }\n" +
						"</style>\n" +
					"</head>\n" +
				"<script>\n" +
				"	var numIncomeRows = 3;\n" +
				"	var numExpenseRows = 3;\n" +
				"	function addIncomeRows() {\n" +
				"		var table = document.getElementById('incomeTable');\n" +
				"		var row = table.insertRow(-1);\n" +
				"		numIncomeRows++;\n" +
				"		var description = row.insertCell(0);\n" +
				"		var income = row.insertCell(1);\n" +
				"		var freq = row.insertCell(2);\n" +
				"		var comment = row.insertCell(3);\n" +
				"		description.innerHTML = \"<input type='text' name='income\" + numIncomeRows + \"'>\"\n" +
				"		income.innerHTML = \"<input type='number' name='incomeValue\" + numIncomeRows + \"'>\"\n" +
				"		freq.innerHTML = \"<input type='number' name='incomeFreq\" + numIncomeRows + \"'>\\n\" +\n" +
				"						 \"		<select name='incomeFreqType\" + numIncomeRows + \"'>\\n\" +\n" +
				"						 \"			<option value='daily'>Daily</option>\\n\" +\n" +
				"						 \"			<option value='weekly'>Weekly</option>\\n\" +\n" +
				"						 \"			<option value='monthly'>Monthly</option>\\n\" +\n" +
				"						 \"			<option value='yearly'>Yearly</option>\\n\" +\n" +
				"						 \"		</select>\"\n" +
				"		comment.innerHTML = \"<textarea rows='3' cols='40' name='incomeComment\" + numIncomeRows + \"'></textarea>\"\n" +
				"	}\n" +
				"	function addExpenseRows() {\n" +
				"		var table = document.getElementById('expenseTable');\n" +
				"		var row = table.insertRow(-1);\n" +
				"		numExpenseRows++;\n" +
				"		var description = row.insertCell(0);\n" +
				"		var income = row.insertCell(1);\n" +
				"		var freq = row.insertCell(2);\n" +
				"		var comment = row.insertCell(3);\n" +
				"		description.innerHTML = \"<input type='text' name='expense\" + numExpenseRows + \"'>\"\n" +
				"		income.innerHTML = \"<input type='number' name='expenseValue\" + numExpenseRows + \"'>\"\n" +
				"		freq.innerHTML = \"<input type='number' name='expenseFreq\" + numExpenseRows + \"'>\\n\" +\n" +
				"						 \"		<select name='expenseFreqType\" + numExpenseRows + \"'>\\n\" +\n" +
				"						 \"			<option value='daily'>Daily</option>\\n\" +\n" +
				"						 \"			<option value='weekly'>Weekly</option>\\n\" +\n" +
				"						 \"			<option value='monthly'>Monthly</option>\\n\" +\n" +
				"						 \"			<option value='yearly'>Yearly</option>\\n\" +\n" +
				"						 \"		</select>\"\n" +
				"		comment.innerHTML = \"<textarea rows='3' cols='40' name='expenseComment\" + numExpenseRows + \"'></textarea>\"\n" +
				"	}\n" +
				"	function removeIncomeRow() {\n" +
				"		if (numIncomeRows > 1) {\n" +
				"			document.getElementById('incomeTable').deleteRow(numIncomeRows);\n" +
				"			numIncomeRows--; }\n" +
				"		else {\n" +
				"			alert('One income row is required.'); }\n" +
				"	}\n" +
				"	function removeExpenseRow() {\n" +
				"		if (numExpenseRows > 1) {\n" +
				"			document.getElementById('expenseTable').deleteRow(numExpenseRows);\n" +
				"			numExpenseRows--; }\n" +
				"		else {\n" +
				"			alert('One expense row is required.'); }\n" +
				"	}\n" +
				"	function openTab(evt, type) {\n" +
				"		var i, tabcontent, tablinks;\n" +
				"		tabcontent = document.getElementsByClassName('tabcontent');\n" +
				"		for (i = 0; i < tabcontent.length; i++) {\n" +
				"			tabcontent[i].style.display = 'none'; }\n" +
				"		tablinks = document.getElementsByClassName('tablinks');\n" +
				"		for (i = 0; i < tablinks.length; i++) {\n" +
				"			tablinks[i].className = tablinks[i].className.replace('active', ''); }\n" +
				"		document.getElementById(type).style.display = 'block';\n" +
				"		evt.currentTarget.className += ' active';\n" +
				"	}\n" +
				"</script>\n" +
				"<body>\n" +
				"	<div>\n" +
				"		<h1 align='center'>\n" +
				"			Hello, " + userName + "! Let's generate your budget\n" +
				"		</h1>\n" +
				"		<div class='form'>\n" +
				"			<form method='POST'>\n" +
				"				<div class='tab'>\n" +
				"					<button type='button' class='tablinks' onclick='openTab(event, \"incomeTab\")'>Income</button>\n" +
				"					<button type='button' class='tablinks' onclick='openTab(event, \"expenseTab\")'>Expenses</button>\n" +
				"				</div>\n" +
				"				<div id='incomeTab' class='tabcontent'>\n" +
				"					<table align='center' id='incomeTable'>\n" +
				"						<tr>\n" +
				"							<td>Income Description</td>\n" +
				"							<td>Amount($)</td>\n" +
				"							<td>Frequency  </td>\n" +
				"							<td>Comment</td>\n" +
				"						</tr>\n" +
				"						<tr>\n" +
				"							<td>\n" +
				"								<input type='text' name='income1'>\n" +
				"							</td>\n" +
				"							<td>\n" +
				"								<input type='number' name='incomeValue1'>\n" +
				"							</td>\n" +
				"							<td>\n" +
				"								<input type='number' name='incomeFreq1'>\n" +
				"								<select name='incomeFreqType1'>\n" +
				"									<option value='daily'>Daily</option>\n" +
				"									<option value='weekly'>Weekly</option>\n" +
				"									<option value='monthly'>Monthly</option>\n" +
				"									<option value='yearly'>Yearly</option>\n" +
				"								</select>\n" +
				"							</td>\n" +
				"							<td>\n" +
				"								<textarea rows='3' cols='40' name='incomeComment1'></textarea>\n" +
				"							</td>\n" +
				"						</tr>\n" +
				"						<tr>\n" +
				"							<td>\n" +
				"								<input type='text' name='income2'>\n" +
				"							</td>\n" +
				"							<td>\n" +
				"								<input type='number' name='incomeValue2'>\n" +
				"							</td>\n" +
				"							<td>\n" +
				"								<input type='number' name='incomeFreq2'>\n" +
				"								<select name='incomeFreqType2'>\n" +
				"									<option value='daily'>Daily</option>\n" +
				"									<option value='weekly'>Weekly</option>\n" +
				"									<option value='monthly'>Monthly</option>\n" +
				"									<option value='yearly'>Yearly</option>\n" +
				"								</select>\n" +
				"							</td>\n" +
				"							<td>\n" +
				"								<textarea rows='3' cols='40' name='incomeComment2'></textarea>\n" +
				"							</td>\n" +
				"						</tr>\n" +
				"						<tr>\n" +
				"							<td>\n" +
				"								<input type='text' name='income3'>\n" +
				"							</td>\n" +
				"							<td>\n" +
				"								<input type='number' name='incomeValue3'>\n" +
				"							</td>\n" +
				"							<td>\n" +
				"								<input type='number' name='incomeFreq3'>\n" +
				"								<select name='incomeFreqType3'>\n" +
				"									<option value='daily'>Daily</option>\n" +
				"									<option value='weekly'>Weekly</option>\n" +
				"									<option value='monthly'>Monthly</option>\n" +
				"									<option value='yearly'>Yearly</option>\n" +
				"								</select>\n" +
				"							</td>\n" +
				"							<td>\n" +
				"								<textarea rows='3' cols='40' name='incomeComment3'></textarea>\n" +
				"							</td>\n" +
				"						</tr>\n" +
				"					</table>\n" +
				"					<button type='button' onclick='removeIncomeRow();'>Remove Income</button>\n" +
				"					<button type='button' onclick='addIncomeRows();'>Add More Income</button>\n" +
				"				</div>\n" +
				"				<div id='expenseTab' class='tabcontent'>\n" +
				"					<table align='center' id='expenseTable'>\n" +
				"						<tr>\n" +
				"							<td>Expense Description</td>\n" +
				"							<td>Amount($)</td>\n" +
				"							<td>Frequency  </td>\n" +
				"							<td>Comment</td>\n" +
				"						</tr>\n" +
				"						<tr>\n" +
				"							<td>\n" +
				"								<input type='text' name='expense1'>\n" +
				"							</td>\n" +
				"							<td>\n" +
				"								<input type='number' name='expenseValue1'>\n" +
				"							</td>\n" +
				"							<td>\n" +
				"								<input type='number' name='expenseFreq1'>\n" +
				"								<select name='expenseFreqType1'>\n" +
				"									<option value='daily'>Daily</option>\n" +
				"									<option value='weekly'>Weekly</option>\n" +
				"									<option value='monthly'>Monthly</option>\n" +
				"									<option value='yearly'>Yearly</option>\n" +
				"								</select>\n" +
				"							</td>\n" +
				"							<td>\n" +
				"								<textarea rows='3' cols='40' name='expenseComment1'></textarea>\n" +
				"							</td>\n" +
				"						</tr>\n" +
				"						<tr>\n" +
				"							<td>\n" +
				"								<input type='text' name='expense2'>\n" +
				"							</td>\n" +
				"							<td>\n" +
				"								<input type='number' name='expenseValue2'>\n" +
				"							</td>\n" +
				"							<td>\n" +
				"								<input type='number' name='expenseFreq2'>\n" +
				"								<select name='expenseFreqType2'>\n" +
				"									<option value='daily'>Daily</option>\n" +
				"									<option value='weekly'>Weekly</option>\n" +
				"									<option value='monthly'>Monthly</option>\n" +
				"									<option value='yearly'>Yearly</option>\n" +
				"								</select>\n" +
				"							</td>\n" +
				"							<td>\n" +
				"								<textarea rows='3' cols='40' name='expenseComment2'></textarea>\n" +
				"							</td>\n" +
				"						</tr>\n" +
				"						<tr>\n" +
				"							<td>\n" +
				"								<input type='text' name='expense3'>\n" +
				"							</td>\n" +
				"							<td>\n" +
				"								<input type='number' name='expenseValue3'>\n" +
				"							</td>\n" +
				"							<td>\n" +
				"								<input type='number' name='expenseFreq3'>\n" +
				"								<select name='expenseFreqType3'>\n" +
				"									<option value='daily'>Daily</option>\n" +
				"									<option value='weekly'>Weekly</option>\n" +
				"									<option value='monthly'>Monthly</option>\n" +
				"									<option value='yearly'>Yearly</option>\n" +
				"								</select>\n" +
				"							</td>\n" +
				"							<td>\n" +
				"								<textarea rows='3' cols='40' name='expenseComment3'></textarea>\n" +
				"							</td>\n" +
				"						</tr>\n" +
				"					</table>\n" +
				"					<button onclick='removeExpenseRow();' type='button'>Remove Expense</button>\n" +
				"					<button onclick='addExpenseRows();' type='button'>Add More Expenses</button>\n" +
				"				</div>\n" +
				"			</form>\n" +
				"		</div>\n" +
				"	</div>\n" +
				"</body>");
		
        out.close();
        return;
    } // end doPost method
    @Override
    public void doGet(HttpServletRequest request,
        HttpServletResponse response)
    throws ServletException, IOException {
        // HTTP GET requests are forwarded on to the doPost method
        // (i.e., toPost handles both HTTP GET and HTTP POST requests)
        doPost(request, response);
    } // end doGet method
} // end firstNumber class
