#  input:
# John,Smith,john.smith@gmail.com,Los Angeles,1
# Jane,Roberts,janer@msn.com,"San Francisco, CA",0
# "Alexandra ""Alex""",Menendez,alex.menendez@gmail.com,Miami,1
# """Alexandra Alex"""
#  
#  output:
# John|Smith|john.smith@gmail.com|Los Angeles|1
# Jane|Roberts|janer@msn.com|San Francisco, CA|0
# Alexandra "Alex"|Menendez|alex.menendez@gmail.com|Miami|1
# "Alexandra Alex"

def parseCSV(s):
    inQuote = False
    res = []
    i = 0
    while i<len(s):
        if inQuote:
            if s[i]=='"':
                if i!=len(s)-1 and s[i+1]=='"':
                    res.append('"')
                    i+=1
                else:
                    inQuote = False
            else:
                res.append(s[i])
        else:
            if s[i]=='"':
                inQuote = True
            elif s[i]==',':
                res.append('|')
            else:
                res.append(s[i])
        i+=1
    
    return ''.join(res)

input1 = 'John,Smith,john.smith@gmail.com,Los Angeles,1'
print parseCSV(input1)
     
input2 = 'Jane,Roberts,janer@msn.com,"San Francisco, CA",0'
print parseCSV(input2)
     
input3 = '"Alexandra ""Alex""",Menendez,alex.menendez@gmail.com,Miami,1'
print parseCSV(input3)

input4 = '"""Alexandra Alex"""'
print parseCSV(input4)

input5 = '"""Alexandra, Alex"""'
print parseCSV(input5)

input6 = '""""Alexandra, Alex""""'
print parseCSV(input6)

