LIB_BASE=$(pwd)/lib
for lib_path in $LIB_BASE/*
do
    if [ -d $lib_path ]
    then
        cd ${lib_path}
        ant jar
    fi
done