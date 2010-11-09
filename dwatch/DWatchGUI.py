from Tkinter import *
from LowLevelGUI import *

class DWatchGUI:
  def __init__(self, parent, eventhandler):
    self.GUI = LowLevelGUI(parent, self)
    self.eventhandler = eventhandler

  # -----------------------------------
  # Events to be sent to the Statechart
  # -----------------------------------
  def topRightPressed(self):
    self.eventhandler.event("topRightPressed")
    print "topRightPressed"

  def topRightReleased(self):
    self.eventhandler.event("topRightReleased")
    print "topRightReleased"
  
  def topLeftPressed(self):
    self.eventhandler.event("topLeftPressed")
    print "topLeftPressed"
  
  def topLeftReleased(self):
    self.eventhandler.event("topLeftReleased")
    print "topLeftReleased"
    
  def bottomRightPressed(self):
    self.eventhandler.event("bottomRightPressed")
    print "bottomRightPressed"

  def bottomRightReleased(self):
    self.eventhandler.event("bottomRightReleased")
    print "bottomRightReleased"
  
  def bottomLeftPressed(self):
    self.eventhandler.event("bottomLeftPressed")
    print "bottomLeftPressed"
  
  def bottomLeftReleased(self):
    self.eventhandler.event("bottomLeftReleased")
    print "bottomLeftReleased"

  def alarmStart(self):
    self.eventhandler.event("alarmStart")
    print "alarmStart"

  # -----------------------------------
  # Interaction with the GUI elements
  # -----------------------------------
  #Modify the state:
  
  def increaseTimeByOne(self):
    self.GUI.increaseTimeByOne()    
   
  def resetChrono(self):
    self.GUI.resetChrono()
    
  def increaseChronoByOne(self):
    self.GUI.increaseChronoByOne()
    
 # chrono
  def clearDisplay(self):
    self.GUI.clearDisplay()
  def hideTime(self):
    self.GUI.hideTime()
  def drawChrono(self):
    self.GUI.drawChrono()

 #synchronize the state with the display:
  def refreshTimeDisplay(self):
    self.GUI.drawTime()

  def refreshChronoDisplay(self):
    self.GUI.drawChrono()

  def refreshDateDisplay(self):
    self.GUI.drawDate()

  def refreshAlarmDisplay(self):
    self.GUI.drawAlarm()

  #Select current display:
  def startSelection(self):
    self.GUI.startSelection()
    
  def selectNext(self):
    self.GUI.selectNext()    
       
  #Modify the state corresponing to the selection  
  def increaseSelection(self):
    self.GUI.increaseSelection()
        
  def stopSelection(self):
    self.GUI.stopSelection()
                    
         
  #Light / Alarm:
  def setIndiglo(self):
    self.GUI.setIndiglo()
    
  def unsetIndiglo(self):
    self.GUI.unsetIndiglo()
    
  def setAlarm(self):
    self.GUI.setAlarm()

  # Query 
  def getTime(self):
    return self.GUI.getTime()

  def getAlarm(self):
    return self.GUI.getAlarm()
     
  #Check if time = alarm set time
  def checkTime(self):
    if self.GUI.getTime()[0] == self.GUI.getAlarm()[0] and self.GUI.getTime()[1] == self.GUI.getAlarm()[1] and self.GUI.getTime()[2] == self.GUI.getAlarm()[2]:
      self.alarm()
      return True
    else:
      return False

