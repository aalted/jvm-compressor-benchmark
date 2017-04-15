#!/bin/sh
 
echo "About to run round-trip test using Silesia corpus files"

# Since there are 12 input files group by 6

java -server -cp lib/japex/\* \
 -Xmx512M \
 -Djava.awt.headless=true \
 -Djapex.runsPerDriver=1 \
 -Djapex.warmupTime=7 \
 -Djapex.runTime=30 \
 -Djapex.numberOfThreads=1 \
 -Djapex.reportsDirectory=reports/silesia-roundtrip \
 -Djapex.plotGroupSize=6 \
 -Djapex.inputDir="testdata/silesia" \
 com.sun.japex.Japex \
 cfg/tests-silesia-roundtrip.xml

echo "Done!";

