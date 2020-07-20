from django.shortcuts import render

# Create your views here.

from django.http import HttpResonse

def index(request):
    return HttpResponse('Hello world')
