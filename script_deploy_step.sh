set -xe
ssh -o PreferredAuthentications=publickey -p $STAGING_SSH_PORT $STAGING_USER@$STAGING_IP \
"docker login -u gitlab-ci-token -p $CI_JOB_TOKEN $CI_REGISTRY \
&& docker rm --force pipeline || true \
&& docker pull $CONTAINER_IMAGE:$CI_COMMIT_REF_NAME \
&& docker run -d --restart on-failure:5 --name pipeline $CONTAINER_IMAGE:$CI_COMMIT_REF_NAME \
&& exit"
