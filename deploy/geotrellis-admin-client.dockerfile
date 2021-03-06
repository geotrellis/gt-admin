FROM nginx


ADD client/target/scala-2.11/classes/index-prod.html                /opt/app/index.html
ADD client/target/scala-2.11/classes/reset.css                      /opt/app/reset.css
ADD client/target/scala-2.11/classes/style.css                      /opt/app/style.css
ADD client/target/scala-2.11/classes/index-bundle.js                /opt/app/index-bundle.js
ADD client/target/scala-2.11/geotrellis-admin-client-opt.js         /opt/app/geotrellis-admin-client-opt.js
ADD client/target/scala-2.11/geotrellis-admin-client-jsdeps.min.js  /opt/app/geotrellis-admin-client-jsdeps.min.js
ADD deploy/favicons.tar.gz /opt/app
COPY deploy/client_entry.sh /opt/client_entry.sh

RUN rm /etc/nginx/conf.d/default.conf
ADD deploy/nginx.conf /etc/nginx

EXPOSE 8090
