package pl.raziel.openweather

import com.google.gson.Gson
import groovy.json.JsonOutput

String appid = new File('C:\\Users\\GO2OSTA\\IdeaProjects\\Groovy\\groovy-path\\groovy-practical\\src\\main\\resources\\api_key.txt').text

def url = "http://api.openweathermap.org/data/2.5/weather?APPID=$appid&q=cambridge,ma"
def jsonTxt = url.toURL().text
println JsonOutput.prettyPrint(jsonTxt)
Gson gson = new Gson()
println gson.fromJson(jsonTxt, Model)

