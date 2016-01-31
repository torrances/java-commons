rf -rf snowball/target
rf -rf trimc-*/target
myfile=$(date +'%Y%m%d_JAVA-COMMONS-%s.tar.gz')
tar cvf $myfile .
mv $myfile $EOD
