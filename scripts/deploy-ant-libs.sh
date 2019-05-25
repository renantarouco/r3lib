#!/bin/sh
BASE=$(pwd)
LIB_BASE=$BASE/lib
cd $LIB_BASE
for lib_name in *
do
    if [ -d $lib_name ]
    then
        cd $LIB_BASE/$lib_name
        for jar_file in *.jar
        do
            mvn deploy:deploy-file \
                -Durl=file://$BASE/repo/ \
                -Dfile=$jar_file \
                -DgroupId=${lib_name%.jar} \
                -DartifactId=${jar_file%.jar} \
                -Dpackaging=jar \
                -Dversion=1.0
        done
    fi
done