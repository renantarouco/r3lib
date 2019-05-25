LIB_BASE=$(pwd)/lib
cd $LIB_BASE
for lib_name in *
do
    if [ -d $lib_name ]
    then
        cd $LIB_BASE/${lib_name}
        ant jar
    fi
done