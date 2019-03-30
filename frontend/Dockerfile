# Build the app
FROM node:11-alpine AS build

WORKDIR /workdir

COPY . .

RUN npm i && npm run docker-build

# Deploy on an nginx server
FROM nginx:1.15-alpine

COPY --from=build /workdir/dist/frontend /usr/share/nginx/html
