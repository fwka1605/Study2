if ( Test-Path “Test.txt” )
{
  Write-Host "Test.txtは存在します"
}
else
{
  Write-Host "Test.txtは存在しません"
}