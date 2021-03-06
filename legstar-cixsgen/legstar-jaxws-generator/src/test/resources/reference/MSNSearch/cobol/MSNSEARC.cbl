       PROCESS XOPTS(APOST)
       PROCESS NOSEQ LIB OPTIMIZE(FULL)
       IDENTIFICATION DIVISION.
       PROGRAM-ID. MSNSEARC.
      *****************************************************************
      * OVERVIEW                                                      *
      * --------                                                      *
      * Sample transaction calling a remote service using DFHWBCLI    *
      * DFHWBCLI is the Web Client Interface available since TS 2.3   *
      * The HTTP body contains raw mainframe data. It is expected     *
      * that the receiver will use LegStar COBOL binding to convert   *
      * payload to a Java object.                                     *
      *                                                               *
      * Program generated by LegStar Mainframe to Jaxws generator.    *
      * Follow the TODO markers to customize this program.            *
      *****************************************************************

       ENVIRONMENT DIVISION.
       CONFIGURATION SECTION.
       DATA DIVISION.
      *****************************************************************
      *        W O R K I N G    S T O R A G E    S E C T I O N        *
      *****************************************************************
       WORKING-STORAGE SECTION.
       
      *---------------------------------------------------------------*
      *  Constants                                                    *
      *---------------------------------------------------------------*
       77  W00-SERVICE-URI PIC X(55) VALUE 'http://192.168.0.112:8080/c2
      -    'ws-MSNSearch/MSNSearchProxy'.


      *---------------------------------------------------------------*
      *  CICS API parameters                                          *
      *---------------------------------------------------------------*
       01  W03-RESP                      PIC S9(9) BINARY VALUE 0.
       01  W03-RESP2                     PIC S9(9) BINARY VALUE 0.
      *
      * DFHWBCLI Commarea layout (hlq.CICS.SDFHCOB)
      *
          COPY DFHWBCLO.    

      *---------------------------------------------------------------*
      *  Work variables                                               *
      *---------------------------------------------------------------*
       01  ERROR-MESSAGE                  PIC X(78) VALUE SPACES.
           88 NO-ERROR-MESSAGE VALUE SPACES.

       01  WS-I                           PIC S9(9) BINARY VALUE ZERO.
       01  WS-DOUBLE-CHAR.
           05  FILLER                     PIC X VALUE LOW-VALUES.
           05  WS-CHAR                    PIC X.
       01  WS-NUM REDEFINES WS-DOUBLE-CHAR PIC 9(4) COMP-5.

      *---------------------------------------------------------------*
      *  Poor man's ASCII to EBCDIC table used to interpret error     *
      *  messages only. Enterprise COBOL users should use DISPLAY-OF. *
      *---------------------------------------------------------------*
       01  W00-ASCII-2-EBCDIC-CHARS.
           05 FILLER                      PIC X(128) VALUE
                                      X'00010203372D2E2F1605250B0C0D0E0F
      -                                '101112133C3D322618193F27221D351F
      -                                '405A7F7B5B6C507D4D5D5C4E6B604B61
      -                                'F0F1F2F3F4F5F6F7F8F97A5E4C7E6E6F
      -                                '7CC1C2C3C4C5C6C7C8C9D1D2D3D4D5D6
      -                                'D7D8D9E2E3E4E5E6E7E8E9ADE0BD5F6D
      -                                '79818283848586878889919293949596
      -                                '979899A2A3A4A5A6A7A8A9C04FD0A107
      -                                ''.
           05 FILLER                      PIC X(128) VALUE
                                      X'00010203372D2E2F1605250B0C0D0E0F
      -                                '101112133C3D322618193F27221D351F
      -                                '405A7F7B5B6C507D4D5D5C4E6B604B61
      -                                'F0F1F2F3F4F5F6F7F8F97A5E4C7E6E6F
      -                                '7CC1C2C3C4C5C6C7C8C9D1D2D3D4D5D6
      -                                'D7D8D9E2E3E4E5E6E7E8E9ADE0BD5F6D
      -                                '79818283848586878889919293949596
      -                                '979899A2A3A4A5A6A7A8A9C04FD0A107
      -                                ''.
       01  FILLER REDEFINES W00-ASCII-2-EBCDIC-CHARS.
           05  W00-ASCII-2-EBCDIC         PIC X OCCURS 256 .

      *---------------------------------------------------------------*
      *  Request parameters expected by target web service            *
      *---------------------------------------------------------------*
       01 COM-REQUEST.
           02  R-Search.
             03  Flags--C PIC 9(9) BINARY.
             03  SortBy--C PIC 9(9) BINARY.
             03  ResultFields--C PIC 9(9) BINARY.
             03  R-string--C PIC 9(9) BINARY.
             03  SourceRequest--C PIC 9(9) BINARY.
             03  Request.
               04  AppID PIC X(40) DISPLAY.
               04  Query PIC X(128) DISPLAY.
               04  CultureInfo PIC X(32) DISPLAY.
               04  SafeSearch PIC X(32) DISPLAY.
               04  Flags OCCURS 1 TO 10 DEPENDING ON Flags--C PIC X(32) 
                   DISPLAY.
               04  Location.
                 05  Latitude COMP-2.
                 05  Longitude COMP-2.
                 05  Radius COMP-2.
               04  Requests.
                 05  SourceRequest OCCURS 0 TO 10 DEPENDING ON 
                     SourceRequest--C.
                   06  R-Source PIC X(32) DISPLAY.
                   06  Offset PIC 9(9) COMP-5.
                   06  R-Count PIC 9(9) COMP-5.
                   06  FileType PIC X(32) DISPLAY.
                   06  SortBy OCCURS 1 TO 10 DEPENDING ON SortBy--C PIC 
                       X(32) DISPLAY.
                   06  ResultFields OCCURS 1 TO 10 DEPENDING ON 
                       ResultFields--C PIC X(32) DISPLAY.
                   06  SearchTagFilters.
                     07  R-string OCCURS 0 TO 10 DEPENDING ON 
                         R-string--C PIC X(32) DISPLAY.

       
      *****************************************************************
      *            L I N K A G E       S E C T I O N                  *
      *****************************************************************
       LINKAGE SECTION.

      *---------------------------------------------------------------*
      *  Reply parameters as returned by target web service           *
      *---------------------------------------------------------------*
       01 COM-REPLY.
           02  SearchResponse.
             03  SearchTag--C PIC 9(9) BINARY.
             03  Result--C PIC 9(9) BINARY.
             03  SourceResponse--C PIC 9(9) BINARY.
             03  Response.
               04  Responses.
                 05  SourceResponse OCCURS 0 TO 10 DEPENDING ON 
                     SourceResponse--C.
                   06  R-Source PIC X(32) DISPLAY.
                   06  Offset PIC 9(9) COMP-5.
                   06  Total PIC 9(9) COMP-5.
                   06  RecourseQuery PIC X(32) DISPLAY.
                   06  Results.
                     07  Result OCCURS 0 TO 10 DEPENDING ON Result--C.
                       08  R-Title PIC X(32) DISPLAY.
                       08  Description PIC X(256) DISPLAY.
                       08  Url PIC X(32) DISPLAY.
                       08  DisplayUrl PIC X(32) DISPLAY.
                       08  CacheUrl PIC X(32) DISPLAY.
                       08  R-Source0 PIC X(32) DISPLAY.
                       08  SearchTags PIC X(32) DISPLAY.
                       08  Phone PIC X(32) DISPLAY.
                       08  DateTime.
                         09  Year PIC 9(9) COMP-5.
                         09  Month PIC 9(9) COMP-5.
                         09  R-Day PIC 9(9) COMP-5.
                         09  Hour PIC 9(9) COMP-5.
                         09  Minute PIC 9(9) COMP-5.
                         09  Second PIC 9(9) COMP-5.
                       08  R-Address.
                         09  AddressLine PIC X(32) DISPLAY.
                         09  PrimaryCity PIC X(32) DISPLAY.
                         09  SecondaryCity PIC X(32) DISPLAY.
                         09  Subdivision PIC X(32) DISPLAY.
                         09  PostalCode PIC X(32) DISPLAY.
                         09  CountryRegion PIC X(32) DISPLAY.
                         09  FormattedAddress PIC X(32) DISPLAY.
                       08  Location.
                         09  Latitude COMP-2.
                         09  Longitude COMP-2.
                         09  Radius COMP-2.
                       08  SearchTagsArray.
                         09  SearchTag OCCURS 0 TO 10 DEPENDING ON 
                             SearchTag--C.
                           10  Name PIC X(32) DISPLAY.
                           10  R-Value PIC X(32) DISPLAY.
                       08  Summary PIC X(32) DISPLAY.
                       08  ResultType PIC X(32) DISPLAY.
                       08  Image.
                         09  ImageURL PIC X(32) DISPLAY.
                         09  ImageWidth PIC 9(9) COMP-5.
                         09  ImageHeight PIC 9(9) COMP-5.
                         09  ImageFileSize PIC 9(9) COMP-5.
                         09  ThumbnailURL PIC X(32) DISPLAY.
                         09  ThumbnailWidth PIC 9(9) COMP-5.
                         09  ThumbnailHeight PIC 9(9) COMP-5.
                         09  ThumbnailFileSize PIC 9(9) COMP-5.
                       08  Video.
                         09  PlayUrl PIC X(32) DISPLAY.
                         09  SourceTitle PIC X(32) DISPLAY.
                         09  Format PIC X(32) DISPLAY.
                         09  RunTime PIC 9(9) COMP-5.
                         09  Width PIC 9(9) COMP-5.
                         09  Height PIC 9(9) COMP-5.
                         09  FileSize PIC 9(9) COMP-5.
                         09  StaticThumbnail.
                           10  URL PIC X(32) DISPLAY.
                           10  Format0 PIC X(32) DISPLAY.
                           10  Width0 PIC 9(9) COMP-5.
                           10  Height0 PIC 9(9) COMP-5.
                           10  FileSize0 PIC 9(9) COMP-5.
                         09  MotionThumbnail.
                           10  URL0 PIC X(32) DISPLAY.
                           10  Format1 PIC X(32) DISPLAY.
                           10  RunTime0 PIC 9(9) COMP-5.
                           10  Width1 PIC 9(9) COMP-5.
                           10  Height1 PIC 9(9) COMP-5.
                           10  FileSize1 PIC 9(9) COMP-5.

               
      *****************************************************************
      *    P R O C E D U R E  D I V I S I O N   S E C T I O N         *
      *****************************************************************
       PROCEDURE DIVISION.

           PERFORM PROLOG THRU
               END-PROLOG.

           PERFORM INVOKE-SERVICE THRU
               END-INVOKE-SERVICE.
               
           PERFORM EPILOG THRU
               END-EPILOG.

           GOBACK.
       
      *---------------------------------------------------------------*
      *  Initialize the DFHWBCLI commarea.                            *
      *---------------------------------------------------------------*
       PROLOG.

           DISPLAY
               'MSNSEARC STARTING ==============================='. 

           PERFORM SET-REQUEST THRU
               END-SET-REQUEST.

           MOVE LOW-VALUES TO DFHWBCLI-ARG.
           
           MOVE WBCLI-VERSION-CURRENT TO WBCLI-VERSION-NO.
           MOVE WBCLI-FUNCTION-CONVERSE TO WBCLI-FUNCTION.
           MOVE WBCLI-METHOD-POST TO WBCLI-METHOD.
      *
      * Send/Receive native data (no conversion)
      *
           MOVE X'13' TO WBCLI-FLAGS.
           SET WBCLI-URL-PTR TO ADDRESS OF W00-SERVICE-URI.
           COMPUTE WBCLI-URL-LEN = LENGTH OF W00-SERVICE-URI.
           SET WBCLI-REQUEST-BODY-PTR TO ADDRESS OF COM-REQUEST.
           COMPUTE WBCLI-REQUEST-BODY-LEN =
               LENGTH OF COM-REQUEST.
           MOVE 'application/octet-stream' TO WBCLI-MEDIATYPE.

           DISPLAY 'PROLOG ENDED'.
           
       END-PROLOG.   EXIT.

      *---------------------------------------------------------------*
      *  Populate the request parameters                              *
      *---------------------------------------------------------------*
       SET-REQUEST.

           DISPLAY 'SET-REQUEST STARTED'.

      *  TODO set input values in COM-REQUEST                         *
           
           DISPLAY 'SET-REQUEST ENDED'.

       END-SET-REQUEST.   EXIT.

      *---------------------------------------------------------------*
      *  Invoke target service and analyze response                   *
      *---------------------------------------------------------------*
       INVOKE-SERVICE.

           DISPLAY 'ABOUT TO INVOKE-SERVICE'.

           EXEC CICS LINK PROGRAM('DFHWBCLI')
                COMMAREA (DFHWBCLI-ARG)
                RESP     (W03-RESP)
                RESP2    (W03-RESP2)
           END-EXEC.
           
      * 
      * Maybe group DFHWEB is not installed in CICS...
      *
           IF (W03-RESP NOT = DFHRESP(NORMAL))
               MOVE 'LINK DFHWBCLI FAILED' TO ERROR-MESSAGE
               PERFORM ABORT-PROGRAM THRU
                   END-ABORT-PROGRAM
           END-IF.

      * 
      * Examine DFHWBCLI own return code. Exceptions are usually
      * timeouts while trying to connect to service
      *
           MOVE WBCLI-RESPONSE TO W03-RESP.
           MOVE WBCLI-REASON   TO W03-RESP2.

           IF (W03-RESP = WBCLI-RESPONSE-DISASTER) OR
              (W03-RESP = WBCLI-RESPONSE-EXCEPTION AND
               W03-RESP2 NOT = WBCLI-REASON-HTTP-ERROR)
               STRING 'DFHWBCLI FAILED TO RUN SERVICE AT '
                      W00-SERVICE-URI
                      DELIMITED BY SIZE INTO ERROR-MESSAGE
               PERFORM ABORT-PROGRAM THRU
                   END-ABORT-PROGRAM
           END-IF.
           
      * 
      * Only accept an HTTP 200 with some content otherwise
      * try to get a human readable error message from the server
      *
           EVALUATE WBCLI-HTTP-STATUS-CODE
               WHEN '200'
                   IF WBCLI-RESPONSE-BODY-LEN NOT > ZERO
                       MOVE 'EMPTY RESPONSE BODY' TO ERROR-MESSAGE
                   ELSE
                       SET ADDRESS OF COM-REPLY
                        TO WBCLI-RESPONSE-BODY-PTR
                   END-IF
               WHEN OTHER
                   IF (WBCLI-RESPONSE-BODY-LEN > ZERO AND
                       WBCLI-MEDIATYPE = 'text/html')
                       PERFORM CONVERT-REPLY THRU
                           END-CONVERT-REPLY
                       MOVE COM-REPLY(1:WBCLI-RESPONSE-BODY-LEN)
                         TO ERROR-MESSAGE
                   ELSE
                       STRING  'HTTP ERROR=' WBCLI-HTTP-STATUS-CODE
                                DELIMITED BY SIZE
                                INTO ERROR-MESSAGE
                   END-IF
           END-EVALUATE.
           
           IF NO-ERROR-MESSAGE 
               PERFORM PRINT-RESULTS THRU
                   END-PRINT-RESULTS
           ELSE
               PERFORM ABORT-PROGRAM THRU
                   END-ABORT-PROGRAM
           END-IF

           DISPLAY 'INVOKE-SERVICE SUCCESS'.

       END-INVOKE-SERVICE.   EXIT.

      *---------------------------------------------------------------*
      *  Display results returned from target service                 *
      *---------------------------------------------------------------*
       PRINT-RESULTS.

      *  TODO do something useful with data returned in  COM-REPLY    *

       END-PRINT-RESULTS.   EXIT.

      *---------------------------------------------------------------*
      *  Terminate program.                                           *
      *---------------------------------------------------------------*
       EPILOG.

           PERFORM EXIT-PROGRAM THRU
               END-EXIT-PROGRAM.
           
       END-EPILOG.   EXIT.

      *---------------------------------------------------------------*
      *  Entity body might contain error messages assumed to be       *
      *  encoded in ASCII. This simplistic routine converts the       *
      *  content into EBCDIC. Conversion is inplace.                  *
      *---------------------------------------------------------------*
       CONVERT-REPLY.
       
           DISPLAY 'CONVERT-REPLY STARTED'.
           
           SET ADDRESS OF COM-REPLY TO WBCLI-RESPONSE-BODY-PTR.
           
           PERFORM VARYING WS-I FROM 1 BY 1
                     UNTIL WS-I > WBCLI-RESPONSE-BODY-LEN
               MOVE COM-REPLY(WS-I:1) TO WS-CHAR
               IF (WS-NUM < 256)
                   MOVE W00-ASCII-2-EBCDIC(WS-NUM + 1)
                     TO COM-REPLY(WS-I:1)
               ELSE
                   MOVE '?' TO COM-REPLY(WS-I:1)
               END-IF
           END-PERFORM.
           
           DISPLAY 'CONVERT-REPLY ENDED'.

       END-CONVERT-REPLY.   EXIT.

      *---------------------------------------------------------------*
      *  Free keyboard and return to CICS                             *
      *---------------------------------------------------------------*
       EXIT-PROGRAM.
       
           EXEC CICS SEND CONTROL FREEKB END-EXEC.
           
           DISPLAY 'MSNSEARC STOPPING ==============================='.
           EXEC CICS RETURN END-EXEC.

       END-EXIT-PROGRAM.   EXIT.

      *---------------------------------------------------------------*
      *  Something went wrong. Report error and exit.                 *
      *---------------------------------------------------------------*
       ABORT-PROGRAM.
           
           PERFORM DISPLAY-ERROR-MESSAGE THRU
               END-DISPLAY-ERROR-MESSAGE.
               
           PERFORM EXIT-PROGRAM THRU
               END-EXIT-PROGRAM.

       END-ABORT-PROGRAM.   EXIT.

      *---------------------------------------------------------------*
      *  Display error messages                                       *
      *---------------------------------------------------------------*
       DISPLAY-ERROR-MESSAGE.

           EXEC CICS SEND TEXT FROM(ERROR-MESSAGE) FREEKB END-EXEC. 
           DISPLAY '************************************************'.
           DISPLAY '* ', ERROR-MESSAGE.
           DISPLAY '* COMPLETION CODE : ', W03-RESP.
           DISPLAY '* REASON CODE     : ', W03-RESP2.
           DISPLAY '************************************************'.

       END-DISPLAY-ERROR-MESSAGE.   EXIT.
       
       END PROGRAM MSNSEARC.
