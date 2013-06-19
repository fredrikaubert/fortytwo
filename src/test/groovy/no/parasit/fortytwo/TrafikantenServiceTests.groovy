package no.parasit.fortytwo

import org.junit.Test

class TrafikantenServiceTests {
  TrafikantenService trafikantenService = new TrafikantenService()

   @Test
  void testInvodeActualWsService() {
       trafikantenService.getDeparturesInfo()
  }

  @Test
  void testParseResponse() {
      def body = new XmlSlurper().parseText(testData)
      def response = body.Body

      trafikantenService.parseResponse(response)
  }




    String testData='''<soap:Envelope xmlns:soap="http://schemas.xmlsoap.org/soap/envelope/" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:xsd="http://www.w3.org/2001/XMLSchema">
   <soap:Body>
      <GetTravelsAfterResponse xmlns="http://www.trafikanten.no/">
         <GetTravelsAfterResult>
            <TravelProposal>
               <i>0</i>
               <j>0</j>
               <DepartureTime>2013-05-26T08:41:00</DepartureTime>
               <ArrivalTime>2013-05-26T08:56:00</ArrivalTime>
               <Remarks/>
               <TravelStages>
                  <TravelStage>
                     <ID>0</ID>
                     <DepartureStop>
                        <ID>3012430</ID>
                        <Name>Hovseter [T-bane]</Name>
                        <District>Oslo</District>
                        <Zone>1</Zone>
                        <X>592451</X>
                        <Y>6646595</Y>
                        <Rank>0</Rank>
                        <Type>Stop</Type>
                        <Stops/>
                        <ShortName>HS</ShortName>
                        <RealTimeStop>true</RealTimeStop>
                        <Lines/>
                        <StopPoints>
                           <StopPoint>
                              <ID>0</ID>
                              <Name>1</Name>
                              <X>0</X>
                              <Y>0</Y>
                           </StopPoint>
                        </StopPoints>
                        <Deviations/>
                        <WalkingDistance>0</WalkingDistance>
                        <ArrivalTime xsi:nil="true"/>
                        <AlightingAllowed>false</AlightingAllowed>
                        <DepartureTime xsi:nil="true"/>
                        <BoardingAllowed>false</BoardingAllowed>
                     </DepartureStop>
                     <DepartureWalkingDistance>0</DepartureWalkingDistance>
                     <DepartureTime>2013-05-26T08:41:00</DepartureTime>
                     <ActualStop>
                        <ID>0</ID>
                        <X>0</X>
                        <Y>0</Y>
                        <Rank>0</Rank>
                        <Type>Stop</Type>
                        <Stops/>
                        <RealTimeStop>false</RealTimeStop>
                        <Lines/>
                        <StopPoints/>
                        <Deviations/>
                        <WalkingDistance>0</WalkingDistance>
                        <ArrivalTime xsi:nil="true"/>
                        <AlightingAllowed>false</AlightingAllowed>
                        <DepartureTime xsi:nil="true"/>
                        <BoardingAllowed>false</BoardingAllowed>
                     </ActualStop>
                     <ActualTime>1980-01-01T00:00:00</ActualTime>
                     <ArrivalStop>
                        <ID>3010011</ID>
                        <Name>Jernbanetorget [T-bane]</Name>
                        <District>Oslo</District>
                        <Zone>1</Zone>
                        <X>597930</X>
                        <Y>6642890</Y>
                        <Rank>0</Rank>
                        <Type>Stop</Type>
                        <Stops/>
                        <ShortName>JER</ShortName>
                        <RealTimeStop>true</RealTimeStop>
                        <Lines/>
                        <StopPoints>
                           <StopPoint>
                              <ID>0</ID>
                              <Name>1</Name>
                              <X>0</X>
                              <Y>0</Y>
                           </StopPoint>
                        </StopPoints>
                        <Deviations/>
                        <WalkingDistance>0</WalkingDistance>
                        <ArrivalTime xsi:nil="true"/>
                        <AlightingAllowed>false</AlightingAllowed>
                        <DepartureTime xsi:nil="true"/>
                        <BoardingAllowed>false</BoardingAllowed>
                     </ArrivalStop>
                     <ArrivalWalkingDistance>0</ArrivalWalkingDistance>
                     <ArrivalTime>2013-05-26T08:56:00</ArrivalTime>
                     <Destination>Vestli</Destination>
                     <LineID>5</LineID>
                     <LineName>5</LineName>
                     <Remarks/>
                     <Deviations/>
                     <TourID>29825</TourID>
                     <TourLineID>2741</TourLineID>
                     <Transportation>Metro</Transportation>
                     <TravelTime/>
                     <WaitingTime/>
                     <Operator/>
                  </TravelStage>
               </TravelStages>
            </TravelProposal>
            <TravelProposal>
               <i>0</i>
               <j>0</j>
               <DepartureTime>2013-05-26T09:11:00</DepartureTime>
               <ArrivalTime>2013-05-26T09:26:00</ArrivalTime>
               <Remarks/>
               <TravelStages>
                  <TravelStage>
                     <ID>0</ID>
                     <DepartureStop>
                        <ID>3012430</ID>
                        <Name>Hovseter [T-bane]</Name>
                        <District>Oslo</District>
                        <Zone>1</Zone>
                        <X>592451</X>
                        <Y>6646595</Y>
                        <Rank>0</Rank>
                        <Type>Stop</Type>
                        <Stops/>
                        <ShortName>HS</ShortName>
                        <RealTimeStop>true</RealTimeStop>
                        <Lines/>
                        <StopPoints>
                           <StopPoint>
                              <ID>0</ID>
                              <Name>1</Name>
                              <X>0</X>
                              <Y>0</Y>
                           </StopPoint>
                        </StopPoints>
                        <Deviations/>
                        <WalkingDistance>0</WalkingDistance>
                        <ArrivalTime xsi:nil="true"/>
                        <AlightingAllowed>false</AlightingAllowed>
                        <DepartureTime xsi:nil="true"/>
                        <BoardingAllowed>false</BoardingAllowed>
                     </DepartureStop>
                     <DepartureWalkingDistance>0</DepartureWalkingDistance>
                     <DepartureTime>2013-05-26T09:11:00</DepartureTime>
                     <ActualStop>
                        <ID>0</ID>
                        <X>0</X>
                        <Y>0</Y>
                        <Rank>0</Rank>
                        <Type>Stop</Type>
                        <Stops/>
                        <RealTimeStop>false</RealTimeStop>
                        <Lines/>
                        <StopPoints/>
                        <Deviations/>
                        <WalkingDistance>0</WalkingDistance>
                        <ArrivalTime xsi:nil="true"/>
                        <AlightingAllowed>false</AlightingAllowed>
                        <DepartureTime xsi:nil="true"/>
                        <BoardingAllowed>false</BoardingAllowed>
                     </ActualStop>
                     <ActualTime>1980-01-01T00:00:00</ActualTime>
                     <ArrivalStop>
                        <ID>3010011</ID>
                        <Name>Jernbanetorget [T-bane]</Name>
                        <District>Oslo</District>
                        <Zone>1</Zone>
                        <X>597930</X>
                        <Y>6642890</Y>
                        <Rank>0</Rank>
                        <Type>Stop</Type>
                        <Stops/>
                        <ShortName>JER</ShortName>
                        <RealTimeStop>true</RealTimeStop>
                        <Lines/>
                        <StopPoints>
                           <StopPoint>
                              <ID>0</ID>
                              <Name>1</Name>
                              <X>0</X>
                              <Y>0</Y>
                           </StopPoint>
                        </StopPoints>
                        <Deviations/>
                        <WalkingDistance>0</WalkingDistance>
                        <ArrivalTime xsi:nil="true"/>
                        <AlightingAllowed>false</AlightingAllowed>
                        <DepartureTime xsi:nil="true"/>
                        <BoardingAllowed>false</BoardingAllowed>
                     </ArrivalStop>
                     <ArrivalWalkingDistance>0</ArrivalWalkingDistance>
                     <ArrivalTime>2013-05-26T09:26:00</ArrivalTime>
                     <Destination>Vestli</Destination>
                     <LineID>5</LineID>
                     <LineName>5</LineName>
                     <Remarks/>
                     <Deviations/>
                     <TourID>29824</TourID>
                     <TourLineID>2749</TourLineID>
                     <Transportation>Metro</Transportation>
                     <TravelTime/>
                     <WaitingTime/>
                     <Operator/>
                  </TravelStage>
               </TravelStages>
            </TravelProposal>
            <TravelProposal>
               <i>0</i>
               <j>0</j>
               <DepartureTime>2013-05-26T09:41:00</DepartureTime>
               <ArrivalTime>2013-05-26T09:56:00</ArrivalTime>
               <Remarks/>
               <TravelStages>
                  <TravelStage>
                     <ID>0</ID>
                     <DepartureStop>
                        <ID>3012430</ID>
                        <Name>Hovseter [T-bane]</Name>
                        <District>Oslo</District>
                        <Zone>1</Zone>
                        <X>592451</X>
                        <Y>6646595</Y>
                        <Rank>0</Rank>
                        <Type>Stop</Type>
                        <Stops/>
                        <ShortName>HS</ShortName>
                        <RealTimeStop>true</RealTimeStop>
                        <Lines/>
                        <StopPoints>
                           <StopPoint>
                              <ID>0</ID>
                              <Name>1</Name>
                              <X>0</X>
                              <Y>0</Y>
                           </StopPoint>
                        </StopPoints>
                        <Deviations/>
                        <WalkingDistance>0</WalkingDistance>
                        <ArrivalTime xsi:nil="true"/>
                        <AlightingAllowed>false</AlightingAllowed>
                        <DepartureTime xsi:nil="true"/>
                        <BoardingAllowed>false</BoardingAllowed>
                     </DepartureStop>
                     <DepartureWalkingDistance>0</DepartureWalkingDistance>
                     <DepartureTime>2013-05-26T09:41:00</DepartureTime>
                     <ActualStop>
                        <ID>0</ID>
                        <X>0</X>
                        <Y>0</Y>
                        <Rank>0</Rank>
                        <Type>Stop</Type>
                        <Stops/>
                        <RealTimeStop>false</RealTimeStop>
                        <Lines/>
                        <StopPoints/>
                        <Deviations/>
                        <WalkingDistance>0</WalkingDistance>
                        <ArrivalTime xsi:nil="true"/>
                        <AlightingAllowed>false</AlightingAllowed>
                        <DepartureTime xsi:nil="true"/>
                        <BoardingAllowed>false</BoardingAllowed>
                     </ActualStop>
                     <ActualTime>1980-01-01T00:00:00</ActualTime>
                     <ArrivalStop>
                        <ID>3010011</ID>
                        <Name>Jernbanetorget [T-bane]</Name>
                        <District>Oslo</District>
                        <Zone>1</Zone>
                        <X>597930</X>
                        <Y>6642890</Y>
                        <Rank>0</Rank>
                        <Type>Stop</Type>
                        <Stops/>
                        <ShortName>JER</ShortName>
                        <RealTimeStop>true</RealTimeStop>
                        <Lines/>
                        <StopPoints>
                           <StopPoint>
                              <ID>0</ID>
                              <Name>1</Name>
                              <X>0</X>
                              <Y>0</Y>
                           </StopPoint>
                        </StopPoints>
                        <Deviations/>
                        <WalkingDistance>0</WalkingDistance>
                        <ArrivalTime xsi:nil="true"/>
                        <AlightingAllowed>false</AlightingAllowed>
                        <DepartureTime xsi:nil="true"/>
                        <BoardingAllowed>false</BoardingAllowed>
                     </ArrivalStop>
                     <ArrivalWalkingDistance>0</ArrivalWalkingDistance>
                     <ArrivalTime>2013-05-26T09:56:00</ArrivalTime>
                     <Destination>Vestli</Destination>
                     <LineID>5</LineID>
                     <LineName>5</LineName>
                     <Remarks/>
                     <Deviations/>
                     <TourID>29823</TourID>
                     <TourLineID>2757</TourLineID>
                     <Transportation>Metro</Transportation>
                     <TravelTime/>
                     <WaitingTime/>
                     <Operator/>
                  </TravelStage>
               </TravelStages>
            </TravelProposal>
            <TravelProposal>
               <i>0</i>
               <j>0</j>
               <DepartureTime>2013-05-26T10:11:00</DepartureTime>
               <ArrivalTime>2013-05-26T10:26:00</ArrivalTime>
               <Remarks/>
               <TravelStages>
                  <TravelStage>
                     <ID>0</ID>
                     <DepartureStop>
                        <ID>3012430</ID>
                        <Name>Hovseter [T-bane]</Name>
                        <District>Oslo</District>
                        <Zone>1</Zone>
                        <X>592451</X>
                        <Y>6646595</Y>
                        <Rank>0</Rank>
                        <Type>Stop</Type>
                        <Stops/>
                        <ShortName>HS</ShortName>
                        <RealTimeStop>true</RealTimeStop>
                        <Lines/>
                        <StopPoints>
                           <StopPoint>
                              <ID>0</ID>
                              <Name>1</Name>
                              <X>0</X>
                              <Y>0</Y>
                           </StopPoint>
                        </StopPoints>
                        <Deviations/>
                        <WalkingDistance>0</WalkingDistance>
                        <ArrivalTime xsi:nil="true"/>
                        <AlightingAllowed>false</AlightingAllowed>
                        <DepartureTime xsi:nil="true"/>
                        <BoardingAllowed>false</BoardingAllowed>
                     </DepartureStop>
                     <DepartureWalkingDistance>0</DepartureWalkingDistance>
                     <DepartureTime>2013-05-26T10:11:00</DepartureTime>
                     <ActualStop>
                        <ID>0</ID>
                        <X>0</X>
                        <Y>0</Y>
                        <Rank>0</Rank>
                        <Type>Stop</Type>
                        <Stops/>
                        <RealTimeStop>false</RealTimeStop>
                        <Lines/>
                        <StopPoints/>
                        <Deviations/>
                        <WalkingDistance>0</WalkingDistance>
                        <ArrivalTime xsi:nil="true"/>
                        <AlightingAllowed>false</AlightingAllowed>
                        <DepartureTime xsi:nil="true"/>
                        <BoardingAllowed>false</BoardingAllowed>
                     </ActualStop>
                     <ActualTime>1980-01-01T00:00:00</ActualTime>
                     <ArrivalStop>
                        <ID>3010011</ID>
                        <Name>Jernbanetorget [T-bane]</Name>
                        <District>Oslo</District>
                        <Zone>1</Zone>
                        <X>597930</X>
                        <Y>6642890</Y>
                        <Rank>0</Rank>
                        <Type>Stop</Type>
                        <Stops/>
                        <ShortName>JER</ShortName>
                        <RealTimeStop>true</RealTimeStop>
                        <Lines/>
                        <StopPoints>
                           <StopPoint>
                              <ID>0</ID>
                              <Name>1</Name>
                              <X>0</X>
                              <Y>0</Y>
                           </StopPoint>
                        </StopPoints>
                        <Deviations/>
                        <WalkingDistance>0</WalkingDistance>
                        <ArrivalTime xsi:nil="true"/>
                        <AlightingAllowed>false</AlightingAllowed>
                        <DepartureTime xsi:nil="true"/>
                        <BoardingAllowed>false</BoardingAllowed>
                     </ArrivalStop>
                     <ArrivalWalkingDistance>0</ArrivalWalkingDistance>
                     <ArrivalTime>2013-05-26T10:26:00</ArrivalTime>
                     <Destination>Vestli</Destination>
                     <LineID>5</LineID>
                     <LineName>5</LineName>
                     <Remarks/>
                     <Deviations/>
                     <TourID>29822</TourID>
                     <TourLineID>2765</TourLineID>
                     <Transportation>Metro</Transportation>
                     <TravelTime/>
                     <WaitingTime/>
                     <Operator/>
                  </TravelStage>
               </TravelStages>
            </TravelProposal>
            <TravelProposal>
               <i>0</i>
               <j>0</j>
               <DepartureTime>2013-05-26T10:41:00</DepartureTime>
               <ArrivalTime>2013-05-26T10:56:00</ArrivalTime>
               <Remarks/>
               <TravelStages>
                  <TravelStage>
                     <ID>0</ID>
                     <DepartureStop>
                        <ID>3012430</ID>
                        <Name>Hovseter [T-bane]</Name>
                        <District>Oslo</District>
                        <Zone>1</Zone>
                        <X>592451</X>
                        <Y>6646595</Y>
                        <Rank>0</Rank>
                        <Type>Stop</Type>
                        <Stops/>
                        <ShortName>HS</ShortName>
                        <RealTimeStop>true</RealTimeStop>
                        <Lines/>
                        <StopPoints>
                           <StopPoint>
                              <ID>0</ID>
                              <Name>1</Name>
                              <X>0</X>
                              <Y>0</Y>
                           </StopPoint>
                        </StopPoints>
                        <Deviations/>
                        <WalkingDistance>0</WalkingDistance>
                        <ArrivalTime xsi:nil="true"/>
                        <AlightingAllowed>false</AlightingAllowed>
                        <DepartureTime xsi:nil="true"/>
                        <BoardingAllowed>false</BoardingAllowed>
                     </DepartureStop>
                     <DepartureWalkingDistance>0</DepartureWalkingDistance>
                     <DepartureTime>2013-05-26T10:41:00</DepartureTime>
                     <ActualStop>
                        <ID>0</ID>
                        <X>0</X>
                        <Y>0</Y>
                        <Rank>0</Rank>
                        <Type>Stop</Type>
                        <Stops/>
                        <RealTimeStop>false</RealTimeStop>
                        <Lines/>
                        <StopPoints/>
                        <Deviations/>
                        <WalkingDistance>0</WalkingDistance>
                        <ArrivalTime xsi:nil="true"/>
                        <AlightingAllowed>false</AlightingAllowed>
                        <DepartureTime xsi:nil="true"/>
                        <BoardingAllowed>false</BoardingAllowed>
                     </ActualStop>
                     <ActualTime>1980-01-01T00:00:00</ActualTime>
                     <ArrivalStop>
                        <ID>3010011</ID>
                        <Name>Jernbanetorget [T-bane]</Name>
                        <District>Oslo</District>
                        <Zone>1</Zone>
                        <X>597930</X>
                        <Y>6642890</Y>
                        <Rank>0</Rank>
                        <Type>Stop</Type>
                        <Stops/>
                        <ShortName>JER</ShortName>
                        <RealTimeStop>true</RealTimeStop>
                        <Lines/>
                        <StopPoints>
                           <StopPoint>
                              <ID>0</ID>
                              <Name>1</Name>
                              <X>0</X>
                              <Y>0</Y>
                           </StopPoint>
                        </StopPoints>
                        <Deviations/>
                        <WalkingDistance>0</WalkingDistance>
                        <ArrivalTime xsi:nil="true"/>
                        <AlightingAllowed>false</AlightingAllowed>
                        <DepartureTime xsi:nil="true"/>
                        <BoardingAllowed>false</BoardingAllowed>
                     </ArrivalStop>
                     <ArrivalWalkingDistance>0</ArrivalWalkingDistance>
                     <ArrivalTime>2013-05-26T10:56:00</ArrivalTime>
                     <Destination>Vestli</Destination>
                     <LineID>5</LineID>
                     <LineName>5</LineName>
                     <Remarks/>
                     <Deviations/>
                     <TourID>29821</TourID>
                     <TourLineID>2781</TourLineID>
                     <Transportation>Metro</Transportation>
                     <TravelTime/>
                     <WaitingTime/>
                     <Operator/>
                  </TravelStage>
               </TravelStages>
            </TravelProposal>
            <TravelProposal>
               <i>0</i>
               <j>0</j>
               <DepartureTime>2013-05-26T10:56:00</DepartureTime>
               <ArrivalTime>2013-05-26T11:11:00</ArrivalTime>
               <Remarks/>
               <TravelStages>
                  <TravelStage>
                     <ID>0</ID>
                     <DepartureStop>
                        <ID>3012430</ID>
                        <Name>Hovseter [T-bane]</Name>
                        <District>Oslo</District>
                        <Zone>1</Zone>
                        <X>592451</X>
                        <Y>6646595</Y>
                        <Rank>0</Rank>
                        <Type>Stop</Type>
                        <Stops/>
                        <ShortName>HS</ShortName>
                        <RealTimeStop>true</RealTimeStop>
                        <Lines/>
                        <StopPoints>
                           <StopPoint>
                              <ID>0</ID>
                              <Name>1</Name>
                              <X>0</X>
                              <Y>0</Y>
                           </StopPoint>
                        </StopPoints>
                        <Deviations/>
                        <WalkingDistance>0</WalkingDistance>
                        <ArrivalTime xsi:nil="true"/>
                        <AlightingAllowed>false</AlightingAllowed>
                        <DepartureTime xsi:nil="true"/>
                        <BoardingAllowed>false</BoardingAllowed>
                     </DepartureStop>
                     <DepartureWalkingDistance>0</DepartureWalkingDistance>
                     <DepartureTime>2013-05-26T10:56:00</DepartureTime>
                     <ActualStop>
                        <ID>0</ID>
                        <X>0</X>
                        <Y>0</Y>
                        <Rank>0</Rank>
                        <Type>Stop</Type>
                        <Stops/>
                        <RealTimeStop>false</RealTimeStop>
                        <Lines/>
                        <StopPoints/>
                        <Deviations/>
                        <WalkingDistance>0</WalkingDistance>
                        <ArrivalTime xsi:nil="true"/>
                        <AlightingAllowed>false</AlightingAllowed>
                        <DepartureTime xsi:nil="true"/>
                        <BoardingAllowed>false</BoardingAllowed>
                     </ActualStop>
                     <ActualTime>1980-01-01T00:00:00</ActualTime>
                     <ArrivalStop>
                        <ID>3010011</ID>
                        <Name>Jernbanetorget [T-bane]</Name>
                        <District>Oslo</District>
                        <Zone>1</Zone>
                        <X>597930</X>
                        <Y>6642890</Y>
                        <Rank>0</Rank>
                        <Type>Stop</Type>
                        <Stops/>
                        <ShortName>JER</ShortName>
                        <RealTimeStop>true</RealTimeStop>
                        <Lines/>
                        <StopPoints>
                           <StopPoint>
                              <ID>0</ID>
                              <Name>1</Name>
                              <X>0</X>
                              <Y>0</Y>
                           </StopPoint>
                        </StopPoints>
                        <Deviations/>
                        <WalkingDistance>0</WalkingDistance>
                        <ArrivalTime xsi:nil="true"/>
                        <AlightingAllowed>false</AlightingAllowed>
                        <DepartureTime xsi:nil="true"/>
                        <BoardingAllowed>false</BoardingAllowed>
                     </ArrivalStop>
                     <ArrivalWalkingDistance>0</ArrivalWalkingDistance>
                     <ArrivalTime>2013-05-26T11:11:00</ArrivalTime>
                     <Destination>Vestli</Destination>
                     <LineID>5</LineID>
                     <LineName>5</LineName>
                     <Remarks/>
                     <Deviations/>
                     <TourID>29820</TourID>
                     <TourLineID>2797</TourLineID>
                     <Transportation>Metro</Transportation>
                     <TravelTime/>
                     <WaitingTime/>
                     <Operator/>
                  </TravelStage>
               </TravelStages>
            </TravelProposal>
            <TravelProposal>
               <i>0</i>
               <j>0</j>
               <DepartureTime>2013-05-26T11:11:00</DepartureTime>
               <ArrivalTime>2013-05-26T11:26:00</ArrivalTime>
               <Remarks/>
               <TravelStages>
                  <TravelStage>
                     <ID>0</ID>
                     <DepartureStop>
                        <ID>3012430</ID>
                        <Name>Hovseter [T-bane]</Name>
                        <District>Oslo</District>
                        <Zone>1</Zone>
                        <X>592451</X>
                        <Y>6646595</Y>
                        <Rank>0</Rank>
                        <Type>Stop</Type>
                        <Stops/>
                        <ShortName>HS</ShortName>
                        <RealTimeStop>true</RealTimeStop>
                        <Lines/>
                        <StopPoints>
                           <StopPoint>
                              <ID>0</ID>
                              <Name>1</Name>
                              <X>0</X>
                              <Y>0</Y>
                           </StopPoint>
                        </StopPoints>
                        <Deviations/>
                        <WalkingDistance>0</WalkingDistance>
                        <ArrivalTime xsi:nil="true"/>
                        <AlightingAllowed>false</AlightingAllowed>
                        <DepartureTime xsi:nil="true"/>
                        <BoardingAllowed>false</BoardingAllowed>
                     </DepartureStop>
                     <DepartureWalkingDistance>0</DepartureWalkingDistance>
                     <DepartureTime>2013-05-26T11:11:00</DepartureTime>
                     <ActualStop>
                        <ID>0</ID>
                        <X>0</X>
                        <Y>0</Y>
                        <Rank>0</Rank>
                        <Type>Stop</Type>
                        <Stops/>
                        <RealTimeStop>false</RealTimeStop>
                        <Lines/>
                        <StopPoints/>
                        <Deviations/>
                        <WalkingDistance>0</WalkingDistance>
                        <ArrivalTime xsi:nil="true"/>
                        <AlightingAllowed>false</AlightingAllowed>
                        <DepartureTime xsi:nil="true"/>
                        <BoardingAllowed>false</BoardingAllowed>
                     </ActualStop>
                     <ActualTime>1980-01-01T00:00:00</ActualTime>
                     <ArrivalStop>
                        <ID>3010011</ID>
                        <Name>Jernbanetorget [T-bane]</Name>
                        <District>Oslo</District>
                        <Zone>1</Zone>
                        <X>597930</X>
                        <Y>6642890</Y>
                        <Rank>0</Rank>
                        <Type>Stop</Type>
                        <Stops/>
                        <ShortName>JER</ShortName>
                        <RealTimeStop>true</RealTimeStop>
                        <Lines/>
                        <StopPoints>
                           <StopPoint>
                              <ID>0</ID>
                              <Name>1</Name>
                              <X>0</X>
                              <Y>0</Y>
                           </StopPoint>
                        </StopPoints>
                        <Deviations/>
                        <WalkingDistance>0</WalkingDistance>
                        <ArrivalTime xsi:nil="true"/>
                        <AlightingAllowed>false</AlightingAllowed>
                        <DepartureTime xsi:nil="true"/>
                        <BoardingAllowed>false</BoardingAllowed>
                     </ArrivalStop>
                     <ArrivalWalkingDistance>0</ArrivalWalkingDistance>
                     <ArrivalTime>2013-05-26T11:26:00</ArrivalTime>
                     <Destination>Vestli</Destination>
                     <LineID>5</LineID>
                     <LineName>5</LineName>
                     <Remarks/>
                     <Deviations/>
                     <TourID>29819</TourID>
                     <TourLineID>2805</TourLineID>
                     <Transportation>Metro</Transportation>
                     <TravelTime/>
                     <WaitingTime/>
                     <Operator/>
                  </TravelStage>
               </TravelStages>
            </TravelProposal>
         </GetTravelsAfterResult>
      </GetTravelsAfterResponse>
   </soap:Body>
</soap:Envelope>'''
}
