set -xe
ssh -o PreferredAuthentications=publickey azureuser@13.73.147.152 \
"docker login -u gitlab-ci-token -p $CI_JOB_TOKEN $CI_REGISTRY \
&& docker rm --force pipeline || true \
&& docker pull $CONTAINER_IMAGE:$CI_COMMIT_REF_NAME \
&& docker run -d --restart on-failure:5 --name pipeline $CONTAINER_IMAGE:$CI_COMMIT_REF_NAME \
&& exit"
