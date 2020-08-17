import plotly.express as px
import pandas as pd

df = pd.DataFrame([
    dict(Task="Trade", Start='2018-01-19', Finish='2018-01-25', Color="Trade"),
    dict(Task="No Trans", Start='2018-01-26', Finish='2018-02-13', Color="No Trans"),
    dict(Task="Trade", Start='2018-02-14', Finish='2018-03-04', Color="Trade"),
    dict(Task="No Trans", Start='2018-03-05', Finish='2018-03-06', Color="No Trans"),
    dict(Task="Trade", Start='2018-03-07', Finish='2018-03-30', Color="Trade"),
    dict(Task="No Trans", Start='2018-04-01', Finish='2018-04-23', Color="No Trans"),
    dict(Task="Trade", Start='2018-04-24', Finish='2018-06-07', Color="Trade"),
    dict(Task="No Trans", Start='2018-06-08', Finish='2018-06-16', Color="No Trans"),
    dict(Task="Trade", Start='2018-06-17', Finish='2018-07-16', Color="Trade"),
    dict(Task="No Trans", Start='2018-07-17', Finish='2018-07-31', Color="No Trans")
])

fig = px.timeline(df, x_start="Start", x_end="Finish", y="Task", color="Color")
fig.update_yaxes(autorange="reversed")
# fig.savefig('Bithumb-BTC2018-timeline.png', dpi=1000)
fig.show()