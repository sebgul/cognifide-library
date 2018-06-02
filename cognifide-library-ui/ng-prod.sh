ng build --prod
rm ../src/main/resources/static/*.*
cp dist/cognifide-library-ui/*.* ../src/main/resources/static/
