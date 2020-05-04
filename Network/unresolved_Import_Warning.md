# Unresolved Import Warning (VSCode)

Hi there, I encountered a similar 'unresolved-import' problem for python inside VSCode, and I may have a solution: Inside VSCode, do these:

Press "Ctrl + Shift + P" : Show all commands

Type: "Configure Language Specific …", then pick "Python"

"settings.json" will open. Check in this json file if there is a line like this: {"python.jediEnabled": false}

If yes, then comment it out, then reload VSCode, the problem should be solved, given that you use external lint source (eg. pylint) instead. That line on (3) indicates the usage of "Microsoft Python Language Server" of IntelliCode extension package. More info can be found here: https://code.visualstudio.com/docs/python/settings-reference

https://www.reddit.com/r/learnpython/comments/a97p09/unresolved_import_warning_vscode/