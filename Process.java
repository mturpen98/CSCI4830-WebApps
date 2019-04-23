package servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.servlet.annotation.WebServlet;
@WebServlet(name = "Process", urlPatterns = {
        "/Process"
})
public class Process extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest request,
                       HttpServletResponse response)
            throws
            ServletException, IOException {
        response.setContentType("text/html");
        final PrintWriter out = response.getWriter();

        // If the checkbox isn't checked the value is null
        // If the checkbox isn't checked the value is "on"
        String testing = request.getParameter("input");

        String userName = "Yeet";

        ArrayList<Entry> listInc = new ArrayList<Entry>();
        ArrayList<Entry> listExp = new ArrayList<Entry>();
        //input.nextLine();

        int i = 1;
        Map<String, String[]> map = request.getParameterMap();
        while(map.get("income"+i) != null){
            String name = map.get("income"+i)[0];
            String val = map.get("incomeValue"+i)[0];
            String intType = map.get("incomeFreqType"+i)[0];
            String intPeriod = map.get("incomeFreq"+i)[0];
            String comment = map.get("incomeComment"+i)[0];
            listInc.add(new Entry(Float.valueOf(val), intType, Integer.valueOf(intPeriod), name, comment));
            i++;
        }
        i = 1;
        System.out.println("Reaching This");
        while(map.get("expense"+i) != null){
            String name = map.get("expense"+i)[0];
            String val = map.get("expenseValue"+i)[0];
            String intType = map.get("expenseFreqType"+i)[0];
            String intPeriod = map.get("expenseFreq"+i)[0];
            String comment = map.get("expenseComment"+i)[0];
            listExp.add(new Entry(Float.valueOf(val), intType, Integer.valueOf(intPeriod), name, comment));
            i++;
        }
        System.out.println("Reaching This too");
        System.out.println("Income");
        for(Entry e : listInc){
            System.out.println(e);
        }
        System.out.println("Expense");
        for(Entry e : listExp){
            System.out.println(e);
        }

        // Grabbing income
        BudgetData weeklyIncomeReport = new BudgetData(listInc);
        double weekIncome = (double) Math.round( weeklyIncomeReport.getWeeklyReport() * 100 ) / 100;

        BudgetData monthlyIncomeReport = new BudgetData(listInc);
        double monthIncome = (double) Math.round( monthlyIncomeReport.getMonthlyReport() * 100 ) / 100;

        BudgetData yearlyIncomeReport = new BudgetData(listInc);
        double yearIncome = (double) Math.round( yearlyIncomeReport.getYearlyReport() * 100 ) / 100;
        
        // Grabbing expenses
        BudgetData weeklyExpenseReport = new BudgetData(listExp);
        double weekExpense = (double) Math.round( weeklyExpenseReport.getWeeklyReport() * 100 ) / 100;

        BudgetData monthlyExpenseReport = new BudgetData(listExp);
        double monthExpense = (double) Math.round( monthlyExpenseReport.getMonthlyReport() * 100 ) / 100;

        BudgetData yearlyExpenseReport = new BudgetData(listExp);
        double yearExpense = (double) Math.round( yearlyExpenseReport.getYearlyReport() * 100 ) / 100;

        // Net Income
        double netWeekIncome = weekIncome - weekExpense;
        double netMonthIncome = monthIncome - monthExpense;
        double netYearIncome = yearIncome - yearExpense;

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
                "</script>\n" +
                "<body>\n" +
				"	<div>\n" +
				"		<h1 align='center'>\n" +
				"			Here's your generated budget!\n" +
                "		</h1>\n" +
                "       <div class ='form'>\n" +
                "           <form>\n" +
                "               <h1 align='center'>\n" +
                "                   Income Summary\n" +
                "               </h1>\n" +
                "               <table>\n");

                for (Entry e: listInc)
                {
                    out.print("<tr>\n"+
                              " <td>" + e.getName() + "</td>\n" +
                              " <td>" + e.getValue() + "</td>\n" +
                              " <td>" + e.getPeriod() + "x " + e.getIntervalType() + "</td>\n" +
                              "</tr>\n");
                }
                out.print("     </table>\n" +
                "               <table>\n" +
                "                   <tr>\n" +
                "                       <td>Weekly Income</td>\n" +
                "                       <td>Monthly Income</td>\n" +
                "                       <td>Yearly Income</td>\n" +
                "                   </tr>\n" +
                "                   <tr>\n" +
                "                       <td>" + weekIncome + "</td>\n" +
                "                       <td>" + monthIncome + "</td>\n" +
                "                       <td>" + yearIncome + "</td>\n" +
                "                   </tr>\n" +
                "               </table>\n" +
                "           </form>\n" +
                "       </div>\n" +
                "       <div class='form'>\n" +
                "           <form>\n" +
                "               <h1 align='center'>\n" +
                "                   Expense  Summary\n" +
                "               </h1>\n" +
                "               <table>\n");

                for (Entry e: listExp)
                {
                    out.print("<tr>\n"+
                              " <td>" + e.getName() + "</td>\n" +
                              " <td>" + e.getValue() + "</td>\n" +
                              " <td>" + e.getPeriod() + "x " + e.getIntervalType() + "</td>\n" +
                              "</tr>\n");
                }
                out.print("     </table>\n" +
                "               <table>\n" +
                "                   <tr>\n" +
                "                       <td>Weekly Expenses</td>\n" +
                "                       <td>Monthly Expenses</td>\n" +
                "                       <td>Yearly Expenses</td>\n" +
                "                   </tr>\n" +
                "                   <tr>\n" +
                "                       <td>" + weekExpense + "</td>\n" +
                "                       <td>" + monthExpense + "</td>\n" +
                "                       <td>" + yearExpense + "</td>\n" +
                "                   </tr>\n" +
                "               </table>\n" +
                "               <div id='piechart'></div>\n" +
                "               <script type='text/javascript' src='https://www.gstatic.com/charts/loader.js'></script>\n" +
                "               <script type='text/javascript'>\n" +
                "                   google.charts.load('current', {'packages':['corechart']});\n" +
                "                   google.charts.setOnLoadCallback(drawChart);\n" +
                "                   function drawChart() {\n" +
                "                       var data = google.visualization.arrayToDataTable([\n" +
                "                       ['Task', 'Hours per Day'],\n" +
                "                       ['Eat', 2],\n" +
                "                       ['Work', 8],\n" +
                "                       ['Gym', 2],\n" +
                "                       ['TV', 4],\n" +
                "                       ['Sleep', 8]\n" +
                "                   ]);\n" +
                "                   var options = {'title': 'My Average Day', 'width':550, 'height':400};\n" +
                "                   var chart = new google.visualization.PieChart(document.getElementById('piechart'));\n" +
                "                   chart.draw(data,options);\n" +
                "                   }\n" +
                "               </script>\n" +
                "           </form>\n" +
                "       </div>\n" +
                "       <div class='form'>\n" +
                "           <form>\n" +
                "               <h1 align='center'>\n" +
                "                   Net Income Summary\n" +
                "               </h1>\n" +
                "               <table>\n" +
                "                   <tr>\n" +
                "                       <td>Net Weekly Income</td>\n" +
                "                       <td>Net Monthly Income</td>\n" +
                "                       <td>Net Yearly Income</td>\n" +
                "                   </tr>\n" +
                "                   <tr>\n" +
                "                       <td>" + netWeekIncome + "</td>\n" +
                "                       <td>" + netMonthIncome + "</td>\n" +
                "                       <td>" + netYearIncome + "</td>\n" +
                "                   </tr>\n" +
                "               </table>\n" +
                "           </form>\n" +
                "       </div>\n" +
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
