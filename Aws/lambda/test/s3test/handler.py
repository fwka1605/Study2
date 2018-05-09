from __future__ import print_function

import json
import urllib
import boto3

print('Loading function')

#http://boto3.readthedocs.io/en/latest/reference/services/s3.html#client
s3 = boto3.client('s3')


def hello(event, context):


    bucket_name = event['Records'][0]['s3']['bucket']['name']
    print('==== bucket information =====')
    print(bucket_name)
    print('=============================')


    #https://github.com/bloomberg/chef-bcs/blob/master/cookbooks/chef-bcs/files/default/s3-example-boto3.py
    print('==== your bucket list ====')
    buckets = s3.list_buckets()
    for bucket in buckets['Buckets']:
        print(bucket.get('Name'))

    print('==== file list in bucket ====')
    # https://github.com/boto/boto3/issues/134
    AWS_S3_BUCKET_NAME = 'd-nuo.co.jp'
    s3_resource = boto3.resource('s3')
    bucket = s3_resource.Bucket(AWS_S3_BUCKET_NAME)
    result = bucket.meta.client.list_objects(Bucket=bucket.name, Delimiter='/')
    for o in result.get('Contents'):
        print(o.get('Key'))


    print('==== file details ====')
    # https://docs.aws.amazon.com/ja_jp/AmazonS3/latest/dev/UsingObjects.html
    GET_OBJECT_KEY_NAME = 'neko.xlsx'
    object = s3.get_object(Bucket=AWS_S3_BUCKET_NAME, Key=GET_OBJECT_KEY_NAME)
    print('ContentType ->' + str(object.get('ContentType')))
    print('ContentLength ->' + str(object.get('ContentLength')))


    print('==== uploaded file ====')
    for rec in event['Records']:
        print(rec['s3']['object']['key'])
    print('=============================')

    print("Received event: " + json.dumps(event, indent=2))